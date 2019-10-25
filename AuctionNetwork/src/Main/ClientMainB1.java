/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import AuctionNetwork.Auctioner;
import AuctionNetwork.Bidder;
import AuctionNetwork.Client;
import java.io.IOException;

/**
 *
 * @author Pumkin
 */
public class ClientMainB1 {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        //Generate bidder
        Bidder bidderA = new Bidder("Crazy bidder");
        
        //Start client
        Client clientBidderA = new Client(bidderA);
        clientBidderA.startClient();

    }
    
}
