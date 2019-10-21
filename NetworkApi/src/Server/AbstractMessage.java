/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import ObserverPattern.IObservable;
import ObserverPattern.IObserver;

/**
 *
 * @author Pumkin
 */
public abstract class AbstractMessage<T extends IObservable,S extends IObserver> {
    private T observable;
    private S observer;
}
