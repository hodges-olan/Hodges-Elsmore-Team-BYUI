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
public class InventoryItem implements Serializable {
    
    // class instance variables
    private String inventoryType;
    private double quantity;
    private String name;
    
    // default constructor
    public InventoryItem() {
    }
    
    // public getter function
    public String getInventoryType() {
        return inventoryType;
    }
    
    // public setter function
    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }
    
    // public getter function
    public double getQuantity() {
        return quantity;
    }
    
    // public setter function
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    
    // public getter function
    public String getName() {
        return name;
    }
    
    // public setter function
    public void setName(String name) {
        this.name = name;
    }    

    // public hashCode function
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    // public toString function
    @Override
    public String toString() {
        return "InventoryItem{" + "inventoryType=" + inventoryType + ", quantity=" + quantity + ", name=" + name + '}';
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
        final InventoryItem other = (InventoryItem) obj;
        if (!Objects.equals(this.inventoryType, other.inventoryType)) {
            return false;
        }
        if (Double.doubleToLongBits(this.quantity) != Double.doubleToLongBits(other.quantity)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
}
