/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Pumkin
 */
public abstract class AbstractClient {
   
        
    public void startClient() throws IOException, ClassNotFoundException{
        
        System.out.println("Client started.");
        
        InetAddress host = InetAddress.getLocalHost();
        Scanner scanner = new Scanner(System.in);
        Socket socket = new Socket(host.getHostName(), 9876);
        
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        
        while(true){
            
            String msg = evaluate(scanner.next());
            oos.writeObject(msg);
            oos.flush();
            
            //read the server response message
            
            String received = (String) ois.readObject();
            String reply = evaluate(received);
            oos.writeObject(reply);
            
            if(finish(received)){
                break;
            }
        }
        //close resources
        ois.close();
        oos.close();
        System.out.println("Client stopped.");
    }

    public abstract String evaluate(String msg);
    
    public abstract boolean finish(String msg);
    
    

    
    
}
