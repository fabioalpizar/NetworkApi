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
public class Auction implements IObserver{
    
    private AuctionItem item;
    private Auctioner auctioner;

    @Override
    public void notifyObserver(String command, Object source) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
