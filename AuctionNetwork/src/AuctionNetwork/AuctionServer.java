/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionNetwork;

import Server.AbstractServer;
import Server.AbstractMessage;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
        String dateStr = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(date);
        String fileName = "AuctLog-" + dateStr + ".txt";
        try {
            FileUtils.writeStringToFile(new File(fileName), log);
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
            case "join":
                reply = "joined";
                break;
            case "bid":
                double bidPrice = Double.parseDouble(comms[1]);
                if(bidPrice > this.auction.getCurrentHiPrice()){
                    this.auction.setCurrentHiPrice(bidPrice);
                    this.auction.setCurrentHiBidder(username);
                }
                break;
            case "leave":
                String bidder = username;
                this.auction.removeBidder(bidder);
              break;
            default:
              break;
        }
        return reply;
    }
    
    
    private String auctionerEval(String msg) throws InterruptedException{
        System.out.println(msg);
        String reply = "";
        switch(msg){
            case "accept":
                if(auction.getCurrentHiPrice() > this.auction.getFinalPrice()){
                    this.auction.setFinalPrice(auction.getCurrentHiPrice());
                }
                break;
            case "wait":
                reply = "Auctioner is thinking...";
                Thread.sleep(10000);
                break;                
            case "show":
                reply = this.getAuction().getItem().toStringItemLink();
                break;
            case "end":
                this.auction.finishAuction();
                reply = "end";
              break;
            default:
              break;
        }
        return reply;
    }
    
    @Override
    public String evaluate(String msg) {
        setLog(msg);
        String reply = "";
        String[] initMsg = msg.split("-");
        if(initMsg[0].equalsIgnoreCase(this.auction.getAuctioner().getUsername())){
            try {
                reply = auctionerEval(initMsg[1]);
            } catch (InterruptedException ex) {
                Logger.getLogger(AuctionServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(initMsg[0].equalsIgnoreCase("add")){
            Gson gson = new Gson();
            Bidder bidder = gson.fromJson(initMsg[1], Bidder.class);
            this.auction.addBidder(bidder);
        }else{
            reply = bidderEval(initMsg[0], initMsg[1]);
        }
        return reply;
    }

    @Override
    public boolean finish(String msg) {
        if(msg.equalsIgnoreCase("end")){
            printLog();
            return true;
        }else{
            return false;
        }
    }

    
    
}
