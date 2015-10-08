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
public class RiddleQuest implements Serializable {
    
    // class instance variables
    private String description;
    private double riddleNumber;

    // default constructor
    public RiddleQuest() {
    }

    // public getter function
    public String getDescription() {
        return description;
    }

    // public setter function
    public void setDescription(String description) {
        this.description = description;
    }

    // public getter function
    public double getRiddleNumber() {
        return riddleNumber;
    }

    // public setter function
    public void setRiddleNumber(double riddleNumber) {
        this.riddleNumber = riddleNumber;
    }

    // public hashCode function
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.riddleNumber) ^ (Double.doubleToLongBits(this.riddleNumber) >>> 32));
        return hash;
    }

    // public toString function
    @Override
    public String toString() {
        return "RiddleQuest{" + "description=" + description + ", riddleNumber=" + riddleNumber + '}';
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
        final RiddleQuest other = (RiddleQuest) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (Double.doubleToLongBits(this.riddleNumber) != Double.doubleToLongBits(other.riddleNumber)) {
            return false;
        }
        return true;
    }
    
}
