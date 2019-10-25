/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RedSocial;

import ObserverPattern.IObserver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class Seguidor implements IObserver{

    private String usuario;
    private String correo;
    private List<Artista> seguidos;

    public Seguidor(String _usuario, String _correo) {
        this.usuario = _usuario;
        this.correo = _correo;
        this.seguidos = new ArrayList();
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

    public List<Artista> getSeguidos() {
        return seguidos;
    }

    public void setSeguidos(List<Artista> seguidos) {
        this.seguidos = seguidos;
    }
    
    public void seguirArtista(Artista artista) {
        seguidos.add(artista);
        artista.addSeguidor(this);
    }
    
    public void likeMensaje(Mensaje mensaje) {
        mensaje.incrementLikes();
    }
    
    public void dislikeMensaje(Mensaje mensaje) {
        mensaje.incrementDislikes();
    }
    
    @Override
    public void notifyObserver(String command, Object source) {
        Mensaje mensaje = null;
        Artista artista = null;
        switch(command) {
            case "levelUp":
                artista = (Artista) source;
                System.out.println("*===================================*\n"
                        + "Artista: " + artista.getNombre() + "\n"
                        + "Alcanzó el nuevo hito de " + artista.getSeguidores().size() + " seguidores");
                break;
            case "levelDown":
                System.out.println("level down");
                break;
            case "nuevoMensaje":
                mensaje = (Mensaje) source;
                System.out.println("*===================================*\n"
                        + mensaje.getMensaje() 
                        + "\nBy: " + mensaje.getArtista().getNombre());
                break;
            case "milestoneLike":
                mensaje = (Mensaje) source;
                System.out.println("*===================================*\nEl post:\n"
                        + mensaje.getMensaje()  + "\n"
                        + "Artista: " + mensaje.getArtista().getNombre() + "\n"
                        + "Alcanzó el nuevo hito de " + mensaje.getLikes() + " likes.");
                break;
        }
    }
    
}
