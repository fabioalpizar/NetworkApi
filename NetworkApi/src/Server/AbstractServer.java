/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 *
 * @author Pumkin
 */
public abstract class AbstractServer {
    
    public void process(){
        listen();
        evaluate();
        respond();
    }
 
    public void listen(){
    }
    public void evaluate(){
    }
    public void respond(){
    }
    
}
