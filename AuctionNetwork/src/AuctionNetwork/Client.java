/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuctionNetwork;

import Server.AbstractClient;
import com.google.gson.Gson;

/**
 *
 * @author Pumkin
 */
public class Client extends AbstractClient{

    private Auctioner auctioner = null;
    private Bidder bidder = null;

    public Client(Auctioner auctioner) {
        this.auctioner = auctioner;
    }
    
    public Client(Bidder bidder) {
        this.bidder = bidder;
    }
    
    @Override
    public String evaluate(String msg) {
        String reply = "";
        if(msg.equalsIgnoreCase("joined")){
            Gson gson = new Gson();
            String jsonString = gson.toJson(this.bidder);
            reply = "add-" + jsonString;
            return reply;
        }else{
            if(this.auctioner != null){
                reply = this.auctioner.getUsername() + "-" + msg;
            }else{
                reply = this.bidder.getUsername() + "-" + msg;
            }
        }
        return reply;
    }

    @Override
    public boolean finish(String msg) {
        if(msg.equalsIgnoreCase("end")){
            
            return true;
        }else{
            return false;
        }
    }
    
}
