/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pumkin
 */
public abstract class AbstractServer {
    
    private static ServerSocket server;
    private static int port = 9876;
    
    public void startServer() throws IOException, ClassNotFoundException{
        System.out.println("Server started.");
        server = new ServerSocket(port);
        while(true){
            System.out.println("Waiting....");
            Socket socketListener = server.accept();
            
            new serverThread(socketListener).start();
            System.out.println("New connection started.");
            
        }
    }
    
    private String listen(ObjectInputStream ois) throws IOException, ClassNotFoundException{
        String msg = (String) ois.readObject();
        return msg;
    }
    
    public abstract String evaluate(String msg);
    
    public abstract boolean finish(String msg);
    
    private void respond(String reply, ObjectOutputStream oos) throws IOException{
        oos.writeObject(reply);
    }
    
    public class serverThread extends Thread{
        protected Socket socketListener;

        public serverThread(Socket socketListener) {
            this.socketListener = socketListener;
        }
        
        public void run(){
            try{    
                ObjectInputStream ois = new ObjectInputStream(socketListener.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socketListener.getOutputStream());
                while(true){

                    String msg = listen(ois);
                    
                    System.out.println(msg);
                    
                    String reply = evaluate(msg);
                    respond(reply, oos);

                    System.out.println(reply);

                    if(finish(reply)){
                        break;
                    }
 
                }
                ois.close();
                oos.close();
                return;
            
            }catch (IOException e) {
            }   catch (ClassNotFoundException ex) {
                Logger.getLogger(AbstractServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }
    
}
