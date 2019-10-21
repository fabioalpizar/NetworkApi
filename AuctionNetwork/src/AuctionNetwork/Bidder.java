/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionNetwork;

import ObserverPattern.IObserver;
import java.util.ArrayList;

/**
 *
 * @author Pumkin
 */
public class Bidder implements IObserver{
    
    private String username;
    private ArrayList<AuctionServer> auctions;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<AuctionServer> getAuctions() {
        return auctions;
    }

    public void addAuctions(AuctionServer auction) {
        this.auctions.add(auction);
    }
    
    public void removeAuctions(AuctionServer auction) {
        for (int i=0; i<this.auctions.size(); i++) {               
            if(this.auctions.equals(auction)){
                this.auctions.remove(i);
            }
        }
    }

    public Bidder(String username) {
        this.username = username;
        this.auctions = new ArrayList<>();
    }

    @Override
    public void notifyObserver(String command, Object source) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
