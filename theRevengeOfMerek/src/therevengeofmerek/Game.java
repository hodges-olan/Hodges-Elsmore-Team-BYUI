/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package therevengeofmerek;

import java.io.Serializable;

/**
 *
 * @author co075oh
 */
public class Game implements Serializable {
    // class instance variables
    private double totalTime;
    
    // default constructor
    public Game() {
    }
    
    // public getter function
    public double getTotalTime() {
        return totalTime;
    }
    
    // public setter function
    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }    
}
