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
    public enum Item {
        bandage,
        potion,
        weapon,
        armor,
        shield;
    }
    
    // default constructor
    public InventoryItem(String inventoryType, double quantity, String name) {
        this.inventoryType = inventoryType;
        this.quantity = quantity;
        this.name = name;
    }
    
    // public getter function
    public String getInventoryType() {
        return inventoryType;
    }
    
    public double getQuantity() {
        return quantity;
    }
    
    public String getName() {
        return name;
    }
    
    // public setter function
    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }
    
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    
    public void setName(String name) {
        this.name = name;
    }    

    // public hashCode function
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.inventoryType);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.quantity) ^ (Double.doubleToLongBits(this.quantity) >>> 32));
        hash = 89 * hash + Objects.hashCode(this.name);
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
