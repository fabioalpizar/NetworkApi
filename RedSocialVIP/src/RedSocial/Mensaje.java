/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RedSocial;

import Server.NetworkServer;
import ObserverPattern.AbstractObservable;
import Server.AbstractMessage;
import Server.AbstractServer;

/**
 *
 * @author Gabriel
 */
public class Mensaje{

    Artista artista;
    private String mensaje;
    private int likes;
    private int dislikes;

    public Mensaje(Artista artista, String mensaje) {
        this.artista = artista;
        this.mensaje = mensaje;
        this.likes = 0;
        this.dislikes = 0;
    }

    public Artista getArtista() {
        return artista;
    }

    public int getLikes() {
        return likes;
    }

    public void incrementLikes() {
        this.likes = likes + 1;
        if (likes % 10 == 0) {
            this.artista.notifyAllObservers("milestoneLike", this);
        }
    }

    public int getDislikes() {
        return dislikes;
    }

    public void incrementDislikes() {
        this.dislikes = dislikes + 1;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public void enviarMensaje() {
        this.artista.notifyAllObservers("nuevoMensaje", this);
        NetworkServer.mensajes.put(Integer.toString( NetworkServer.hashCodeMensaje(this)), this);
    }
    
}
