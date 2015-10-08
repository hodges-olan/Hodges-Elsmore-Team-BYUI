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
public class Location implements Serializable {
    
    // class instance variables
    private double row;
    private double column;
    private double questComplete;

    // default constructor
    public Location() {
    }

    // public getter function
    public double getRow() {
        return row;
    }

    // public setter function
    public void setRow(double row) {
        this.row = row;
    }

    // public getter function
    public double getColumn() {
        return column;
    }

    // public setter function
    public void setColumn(double column) {
        this.column = column;
    }

    // public getter function
    public double getQuestComplete() {
        return questComplete;
    }

    // public setter function
    public void setQuestComplete(double questComplete) {
        this.questComplete = questComplete;
    }

    // public hashCode function
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.row) ^ (Double.doubleToLongBits(this.row) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.column) ^ (Double.doubleToLongBits(this.column) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.questComplete) ^ (Double.doubleToLongBits(this.questComplete) >>> 32));
        return hash;
    }

    // public toString function
    @Override
    public String toString() {
        return "Location{" + "row=" + row + ", column=" + column + ", questComplete=" + questComplete + '}';
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
        final Location other = (Location) obj;
        if (Double.doubleToLongBits(this.row) != Double.doubleToLongBits(other.row)) {
            return false;
        }
        if (Double.doubleToLongBits(this.column) != Double.doubleToLongBits(other.column)) {
            return false;
        }
        if (Double.doubleToLongBits(this.questComplete) != Double.doubleToLongBits(other.questComplete)) {
            return false;
        }
        return true;
    }
    
}
