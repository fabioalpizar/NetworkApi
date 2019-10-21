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
            AbstractMessage msg = listen(socketListener);
            AbstractMessage reply = evaluate(msg);
            respond(reply, socketListener);
            socketListener.close();
            if(finish(reply)) break;
        }
        System.out.println("Shutting down server.");
        server.close();
    }
    
    private AbstractMessage listen(Socket socketListener) throws IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(socketListener.getInputStream());
        AbstractMessage msg = (AbstractMessage) ois.readObject();
        ois.close();
        return msg;
    }
    
    public abstract AbstractMessage evaluate(AbstractMessage msg);
    
    public abstract boolean finish(AbstractMessage msg);
    
    private void respond(AbstractMessage reply, Socket socketListener) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(socketListener.getOutputStream());
        oos.writeObject(reply);
        oos.close();
    }
    
    
    
}
