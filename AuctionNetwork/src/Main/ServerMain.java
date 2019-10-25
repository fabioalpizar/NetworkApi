/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import AuctionNetwork.*;
import java.io.IOException;

/**
 *
 * @author Pumkin
 */
public class ServerMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       
        //Generate auctioner
        Auctioner auctionerA = new Auctioner("Big Daddy $$$");
        //Generate items
        AuctionItem itemA = new AuctionItem("Air Jordan 1s (Orange Peel Color)",
                                            "Rare ass orange color J1s",
                                            88.88,
                                            "https://i.pinimg.com/originals/98/8b/6d/988b6d8025410e22dcfa4a0984b73a1a.jpg");
        //Generate Auction
        Auction AuctionA = new Auction(itemA, auctionerA);
        
        
        //Start server
        AuctionServer serverA = new AuctionServer(AuctionA);
        serverA.startServer();
        
    }
    
}
