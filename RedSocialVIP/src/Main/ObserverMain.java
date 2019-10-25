/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import RedSocial.Artista;
import RedSocial.Mensaje;
import RedSocial.Seguidor;

/**
 *
 * @author Gabriel
 */
public class ObserverMain {
    
    public static void main(String[] args) {
        
        // Nuevo artista
        Artista a1 = new Artista("gabo","gabo@gmail.com","Gabriel Quesada");
        
        // Nuevo seguidor
        Seguidor s1 = new Seguidor("fabio","fabio@gmail.com");
        s1.seguirArtista(a1);
        
        // Mensaje del artista
        // Solo le llega a un seguidor (solo lo imprime una vez)
        Mensaje m1 = a1.nuevoMensaje("Hello friend");
        
        // Nuevo seguidor
        Seguidor s2 = new Seguidor("fabio","fabio@gmail.com");
        s2.seguirArtista(a1);
        
        // Nuevo mensaje
        // Le llega a 2 seguidores (lo imprime 2 veces)
        Mensaje m2 = a1.nuevoMensaje("Bye friend");
        
        // Likes al mensaje
        s1.likeMensaje(m2);
        s1.likeMensaje(m2);
        s1.likeMensaje(m2);
        s1.likeMensaje(m2);
        s1.likeMensaje(m2);
        s2.likeMensaje(m2);
        s2.likeMensaje(m2);
        s2.likeMensaje(m2);
        s2.likeMensaje(m2);
        // Con el 10 like manda el aviso de 10 likes a los 2 seguidores (imprime 2 veces)
        s2.likeMensaje(m2);
        
        
        
        
    }
    
    
}
