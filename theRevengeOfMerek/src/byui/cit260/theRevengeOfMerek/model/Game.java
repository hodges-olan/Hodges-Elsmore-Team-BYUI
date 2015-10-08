/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.model;

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

    // public hashCode function
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.totalTime) ^ (Double.doubleToLongBits(this.totalTime) >>> 32));
        return hash;
    }

    // public toString function
    @Override
    public String toString() {
        return "Game{" + "totalTime=" + totalTime + '}';
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
        final Game other = (Game) obj;
        if (Double.doubleToLongBits(this.totalTime) != Double.doubleToLongBits(other.totalTime)) {
            return false;
        }
        return true;
    }
    
}
