/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionNetwork;

import ObserverPattern.AbstractObservable;
import java.util.ArrayList;

/**
 *
 * @author Pumkin
 */
public class Auction extends AbstractObservable{
    
    private AuctionItem item;
    private Auctioner auctioner;
    private ArrayList<Bidder> bidders;
    private Bidder currentHiBidder;

    public Auction(AuctionItem item, Auctioner auctioner) {
        this.item = item;
        this.auctioner = auctioner;
        this.bidders = new ArrayList<>();
        this.currentHiBidder = null;
    }

    public AuctionItem getItem() {
        return item;
    }

    public void setItem(AuctionItem item) {
        this.item = item;
    }

    public Auctioner getAuctioner() {
        return auctioner;
    }

    public void setAuctioner(Auctioner auctioner) {
        this.auctioner = auctioner;
    }

    public ArrayList<Bidder> getBidders() {
        return bidders;
    }

    public void addBidder(Bidder bidder) {
        this.bidders.add(bidder);
        notifyAllObservers("bidderJoined", this);
    }
    
    public void removeBidder(String bidder) {
        for (int i=0; i < this.bidders.size(); i++){
            if(this.bidders.get(i).getUsername().equalsIgnoreCase(bidder)){
               this.bidders.remove(i);
            }
        } 
        notifyAllObservers("bidderLeft", this);
    }
    
    public void setFinalPrice(double price){
        this.item.setFinalPrice(price);
        notifyAllObservers("newFinalPrice", this);
    }
    
    public double getFinalPrice(){
        return this.item.getFinalPrice();
    }

    public Bidder getCurrentHiBidder() {
        return currentHiBidder;
    }

    public void setCurrentHiBidder(String bidder) {
        for (int i=0; i < this.bidders.size(); i++){
            if(this.bidders.get(i).getUsername().equalsIgnoreCase(bidder)){
               this.currentHiBidder = this.bidders.get(i);
            }
        }
        notifyAllObservers("newHiBidder", this);
    }
    
    
    
}
