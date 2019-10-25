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
        if(isArtista) {
            
        } else {
            
        }
        return msg;
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
