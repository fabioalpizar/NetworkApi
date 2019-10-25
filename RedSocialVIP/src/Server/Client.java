/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import RedSocial.Artista;
import RedSocial.Mensaje;
import RedSocial.Seguidor;
import Server.AbstractClient;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class Client extends AbstractClient {
    
    public Artista artista;
    public Seguidor seguidor;
    private boolean isArtista;

    public Client(Artista artista) {
        this.artista = artista;
        this.isArtista = true;
    }

    public Client(Seguidor seguidor) {
        this.seguidor = seguidor;
        this.isArtista = false;
    }
    
    @Override
    public String evaluate(String msg) {
        String reply = "";
        Gson gson = new Gson();
        if(msg.equalsIgnoreCase("join")){
            if(isArtista) {
                String jsonString = gson.toJson(this.artista);
                reply = "addA-" + jsonString;
                return reply;
            } else {
                String jsonString = gson.toJson(this.seguidor);
                reply = "addS-" + jsonString;
                return reply;
            }
        } else if (msg.equalsIgnoreCase("added")){
            reply = "Joined succesfully";
            
        }
        return reply;
    }

    @Override
    public boolean finish(String msg) {
        if(msg.equalsIgnoreCase("salir")){
            return true;
        }else{
            return false;
        }
    }

    
}
