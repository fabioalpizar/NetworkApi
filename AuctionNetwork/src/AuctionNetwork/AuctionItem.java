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
public class AuctionItem {
    private String name;
    private String description;
    private String itemLink;
    private double initialPrice;
    private double finalPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getItemLink() {
        return itemLink;
    }

    public void setItemLink(String itemLink) {
        this.itemLink = itemLink;
    }
    
    public String toStringItemLink() {
        String str = "Name: " + this.getName()
                    + "\n Description: " + this.getDescription()
                    + "\n Image: " + this.getItemLink();
        return str;
    }
    
    public AuctionItem(String name, String description, double initialPrice, String itemLink) {
        this.name = name;
        this.description = description;
        this.initialPrice = initialPrice;
        this.finalPrice = initialPrice;
        this.itemLink = itemLink;
    }
    
    
    
    
}
