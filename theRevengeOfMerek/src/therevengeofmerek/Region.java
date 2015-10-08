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
public class Region implements Serializable {
    // class instance variables
    private String name;
    private String lord;
    private double questsCompleted;
    
    // default constructor
    public Region() {
    }
    
    // public getter function
    public String getName() {
        return name;
    }
    
    // public setter function
    public void setName(String name) {
        this.name = name;
    } 
    
    // public getter function
    public String getLord() {
        return lord;
    }
    
    // public setter function
    public void setLord(String lord) {
        this.lord = lord;
    } 
    
    // public getter function
    public double getQuestsCompleted() {
        return questsCompleted;
    }
    
    // public setter function
    public void setQuestsCompleted(double questsCompleted) {
        this.questsCompleted = questsCompleted;
    }     
}
