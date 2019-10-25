/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import RedSocial.Artista;
import RedSocial.Mensaje;
import RedSocial.Seguidor;
import Server.AbstractServer;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class NetworkServer extends AbstractServer {
    
    public static HashMap<String, Artista> artistas = new HashMap<>();
    public static HashMap<String, Mensaje> mensajes = new HashMap<>();
    public static HashMap<String, Seguidor> seguidores = new HashMap<>();

    public HashMap<String, Artista> getArtistas() {
        return artistas;
    }

    public void nuevoArtistaa(Artista artista) {
        this.artistas.put(artista.getUsuario(), artista);
    }

    public void nuevoSeguidor(Seguidor seguidor) {
        this.seguidores.put(seguidor.getUsuario(), seguidor);
    }
    
    public void nuevoMensaje(Mensaje mensaje) {
        this.mensajes.put("", mensaje);
    }
    
    public static int hashCodeMensaje(Mensaje mensaje) {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(mensaje);
        return hash;
    }
    
    @Override
    public String evaluate(String msg) {
        String response = "";
        Gson gson = new Gson();
        String[] initMsg = msg.split("-");
        String command = initMsg[0];
        switch(command) {
            case "follow":
                response = "seguir";
                break;
            case "salir":
                response = "salir";
                break;
            case "addA":
                Artista artista = gson.fromJson(initMsg[1], Artista.class);
                artistas.put(artista.getUsuario(), artista);
                response = "added";
                break;
            case "addS":
                Seguidor seguidor = gson.fromJson(initMsg[1], Seguidor.class);
                seguidores.put(seguidor.getUsuario(), seguidor);
                response = "added";
                break;
        }
        return response;
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
