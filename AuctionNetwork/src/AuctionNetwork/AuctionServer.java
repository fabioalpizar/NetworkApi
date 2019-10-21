/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionNetwork;

import Server.AbstractServer;
import Server.AbstractMessage;

/**
 *
 * @author Pumkin
 */
public class AuctionServer extends AbstractServer{
    private Auction auction;
    private Bidder bidder;
    private String log;


    @Override
    public AbstractMessage evaluate(AbstractMessage msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean finish(AbstractMessage msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
