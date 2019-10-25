/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import RedSocial.Artista;
import RedSocial.Seguidor;
import Server.Client;
import java.io.IOException;

/**
 *
 * @author Gabriel
 */
public class SeguidorClient1 {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        Seguidor seguidor = new Seguidor("fabio","fabio@gmail.com");
        
        Client cliente = new Client(seguidor);
        cliente.startClient();
        
    }
    
}
