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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Gabriel
 */
public class Artista extends AbstractObservable{

    private String usuario;
    private String correo;
    private String nombre;
    private List<Seguidor> seguidores;
    private int nivel;
    private List<Mensaje> mensajes;

    public Artista(String usuario, String correo, String nombre) {
        this.usuario = usuario;
        this.correo = correo;
        this.nombre = nombre;
        this.seguidores = new ArrayList();
        this.nivel = 0;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Seguidor> getSeguidores() {
        return seguidores;
    }
    
    public void addSeguidor(Seguidor seguidor) {
        this.seguidores.add(seguidor);
        super.addObserver(seguidor);
        if (seguidores.size() % 10 == 0) {
            aumentarNivel();
        }
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    private void aumentarNivel() {
        this.nivel = nivel+1;
        notifyAllObservers("levelUp", this);
    }
    
    private void disminuirNivel() {
        this.nivel = nivel-1;
        notifyAllObservers("levelDown", this);
    }
    
    public Mensaje nuevoMensaje(String texto) {
        Mensaje mensaje = new Mensaje(this, texto);
        //this.mensajes.add(mensaje);
        notifyAllObservers("nuevoMensaje", mensaje);
        NetworkServer.mensajes.put(Integer.toString(NetworkServer.hashCodeMensaje(mensaje)), mensaje);
        return mensaje;
    }

}
