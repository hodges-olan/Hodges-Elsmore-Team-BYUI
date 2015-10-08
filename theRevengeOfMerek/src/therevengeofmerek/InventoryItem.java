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
}
