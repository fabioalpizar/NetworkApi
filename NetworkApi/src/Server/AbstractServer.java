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

/**
 *
 * @author Pumkin
 */
public abstract class AbstractServer {
    
    private static ServerSocket server;
    private static int port = 9876;
    
    void startServer() throws IOException, ClassNotFoundException{
        server = new ServerSocket(port);
        while(true){
            Socket socketListener = server.accept();
            String msg = listen(socketListener);
            String reply = evaluate(msg);
            respond(reply, socketListener);
            if(msg.equalsIgnoreCase("end")) break;
            socketListener.close();
        }
        System.out.println("Shutting down server.");
        server.close();
    }
    
    private String listen(Socket socketListener) throws IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(socketListener.getInputStream());
        String msg = (String) ois.readObject();
        ois.close();
        return msg;
    }
    private String evaluate(String msg){
        return msg;
    }
    private void respond(String reply, Socket socketListener) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(socketListener.getOutputStream());
        oos.writeObject(reply);
        oos.close();
    }
    
}
