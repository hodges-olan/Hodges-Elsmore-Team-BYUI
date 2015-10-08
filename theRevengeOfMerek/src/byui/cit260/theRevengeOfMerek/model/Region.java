/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.model;

import java.io.Serializable;
import java.util.Objects;

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

    // public hashCode function
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.lord);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.questsCompleted) ^ (Double.doubleToLongBits(this.questsCompleted) >>> 32));
        return hash;
    }

    // public toString function
    @Override
    public String toString() {
        return "Region{" + "name=" + name + ", lord=" + lord + ", questsCompleted=" + questsCompleted + '}';
    }

    // public equals function
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Region other = (Region) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.lord, other.lord)) {
            return false;
        }
        if (Double.doubleToLongBits(this.questsCompleted) != Double.doubleToLongBits(other.questsCompleted)) {
            return false;
        }
        return true;
    }
    
}
