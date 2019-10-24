/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionNetwork;

import Server.AbstractServer;
import Server.AbstractMessage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Pumkin
 */
public class AuctionServer extends AbstractServer{
    private Auction auction;
    private String log;

    public AuctionServer(Auction auction) {
        this.auction = auction;
        this.log = "";
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public void printLog() {
        Date date = new Date();
        String fileName = "AuctLog: " + date.toString() + ".txt";
        try {
            FileUtils.writeStringToFile(new File(fileName), this.log);
        } catch (IOException ex) {
            Logger.getLogger(AuctionServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setLog(String event) {
        this.log = this.log + event;
    }

    
    private String bidderEval(String username, String msg){
        String reply = "";
        String[] comms = msg.split("/");
        switch(comms[0]){
            case "bid":
                int bidPrice = Integer.parseInt(comms[1]);
                if(bidPrice > this.auction.getFinalPrice()){
                    this.auction.setFinalPrice(bidPrice);
                    this.auction.setCurrentHiBidder(username);
                }
                break;
            case "leave":
                String bidder = username;
                this.auction.removeBidder(bidder);
              break;
            case "chat":
                reply = comms[1];
              break;
            default:
              break;
        }
        return reply;
    }
    
    
    private String auctionerEval(String msg) throws InterruptedException{
        String reply = "";
        switch(msg){
            case "accept":
                int bidPrice = Integer.parseInt(msg);
                if(bidPrice > this.auction.getFinalPrice()){
                    this.auction.setFinalPrice(bidPrice);
                }
                break;
            case "wait":
                Thread.sleep(10000);
                reply = "Auctioner is thinking...";                
            case "end":
                reply = "end";
              break;
            default:
              break;
        }
        return reply;
    }
    
    @Override
    public String evaluate(String msg) {
        String reply = "";
        String[] initMsg = msg.split("-");
        if(initMsg[0].equalsIgnoreCase(this.auction.getAuctioner().getUsername())){
            try {
                reply = auctionerEval(initMsg[1]);
            } catch (InterruptedException ex) {
                Logger.getLogger(AuctionServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            reply = bidderEval(initMsg[0], initMsg[1]);
        }
        return reply;
    }

    @Override
    public boolean finish(String msg) {
        if(msg.equalsIgnoreCase("end")){
            printLog();
            return false;
        }else{
            return true;
        }
    }

    
    
}
