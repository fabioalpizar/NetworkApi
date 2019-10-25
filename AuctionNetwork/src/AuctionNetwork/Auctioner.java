/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionNetwork;

import ObserverPattern.IObserver;

/**
 *
 * @author Pumkin
 */
public class Auctioner implements IObserver{
    
    private String username;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Auctioner(String username) {
        this.username = username;
    }

    @Override
    public void notifyObserver(String command, Object source) {
        Auction auct = (Auction) source;
        switch(command){
            case "bidderJoined":
                System.out.println(auct.getBidders().get(auct.getBidders().size()-1) + " joined the auction.");
                break;
            case "newHiBidder":
                System.out.println("Current highest bid: " + auct.getCurrentHiBidder()
                + "\nby bidder: " + auct.getCurrentHiBidder());
                break;
            default:
              break;
        }
    }
    
    
    
}
