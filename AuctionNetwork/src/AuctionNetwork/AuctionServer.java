/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionNetwork;

import Server.AbstractServer;

/**
 *
 * @author Pumkin
 */
public class AuctionServer extends AbstractServer{
    private Auctioner auctioner;
    private AuctionItem auctionItem;
    private String log;
    
    String evaluate(String msg){
        return msg;
    }
}
