/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionNetwork;

/**
 *
 * @author Pumkin
 */
public class Auctioner {
    
    private String username;
    private AuctionItem auctionItem;
    private int port;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AuctionItem getAuctionItem() {
        return auctionItem;
    }

    public void setAuctionItem(AuctionItem auctionItem) {
        this.auctionItem = auctionItem;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Auctioner(String username, AuctionItem auctionItem, int port) {
        this.username = username;
        this.auctionItem = auctionItem;
        this.port = port;
    }
    
    
    
}
