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
public class StorageContainerQuest implements Serializable {
    
    // class instance variables
    private String description;
    private double requiredVolume;
    private double radius;
    private double height;

    // default constructor
    public StorageContainerQuest() {
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
    public double getRequiredVolume() {
        return requiredVolume;
    }

    // public setter function
    public void setRequiredVolume(double requiredVolume) {
        this.requiredVolume = requiredVolume;
    }

    // public getter function
    public double getRadius() {
        return radius;
    }

    // public setter function
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // public getter function
    public double getHeight() {
        return height;
    }

    // public setter function
    public void setHeight(double height) {
        this.height = height;
    }

    // public hashCode function
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.description);
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.requiredVolume) ^ (Double.doubleToLongBits(this.requiredVolume) >>> 32));
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.radius) ^ (Double.doubleToLongBits(this.radius) >>> 32));
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.height) ^ (Double.doubleToLongBits(this.height) >>> 32));
        return hash;
    }

    // public toString function
    @Override
    public String toString() {
        return "StorageContainerQuest{" + "description=" + description + ", requiredVolume=" + requiredVolume + ", radius=" + radius + ", height=" + height + '}';
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
        final StorageContainerQuest other = (StorageContainerQuest) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (Double.doubleToLongBits(this.requiredVolume) != Double.doubleToLongBits(other.requiredVolume)) {
            return false;
        }
        if (Double.doubleToLongBits(this.radius) != Double.doubleToLongBits(other.radius)) {
            return false;
        }
        if (Double.doubleToLongBits(this.height) != Double.doubleToLongBits(other.height)) {
            return false;
        }
        return true;
    }
    
}
