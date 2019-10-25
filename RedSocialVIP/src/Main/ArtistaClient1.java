/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import RedSocial.Artista;
import Server.Client;
import java.io.IOException;

/**
 *
 * @author Gabriel
 */
public class ArtistaClient1 {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        Artista artista = new Artista("gaboq","gaboq98@gmail.com","Gabriel Quesada");
        
        Client cliente = new Client(artista);
        cliente.startClient();

    }
    
    
}
