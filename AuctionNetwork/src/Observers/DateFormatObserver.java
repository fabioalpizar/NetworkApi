/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observers;

import ObserverPattern.IObserver;
import java.util.Date;

public class DateFormatObserver implements IObserver{          
    @Override       
    public void notifyObserver(String command, Object source) {           
        if(command.equals("defaultDateFormat")){               
            ConfigurationManager conf = (ConfigurationManager)source;               
            System.out.println("Observer ==> DateFormatObserver.dateFormatChange > "                        
                    + conf.getDefaultDateFormat().format(new Date()));           
        }
    }
}

