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
   
        
    void startClient() throws IOException, ClassNotFoundException{
        
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = new Socket(host.getHostName(), 9876);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        
        Scanner scanner = new Scanner(System.in);
        
        while(true){

            //write to socket using ObjectOutputStream
            
            if(scanner.hasNext())
            {
                oos.write(scanner.nextLine().getBytes());
                oos.flush();
            }
            
            //read the server response message
            
            String received = (String) ois.readObject();
            System.out.println("Message: " + received);
            
            //close resources
            ois.close();
            oos.close();
            
            if(finish(received)) break;
        }
    }

    public abstract String evaluate(String msg);
    
    public abstract boolean finish(String msg);
    
    

    
    
}
