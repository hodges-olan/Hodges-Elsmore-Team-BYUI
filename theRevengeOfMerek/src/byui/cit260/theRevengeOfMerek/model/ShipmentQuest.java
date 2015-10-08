/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.model;

import java.util.Objects;

/**
 *
 * @author co075oh
 */
public class ShipmentQuest {
    
    // class instance variables
    private String description;
    private String shipmentName;
    private String shipmentDestination;

    // default constructor
    public ShipmentQuest() {
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
    public String getShipmentName() {
        return shipmentName;
    }

    // public setter function
    public void setShipmentName(String shipmentName) {
        this.shipmentName = shipmentName;
    }

    // public getter function
    public String getShipmentDestination() {
        return shipmentDestination;
    }

    // public setter function
    public void setShipmentDestination(String shipmentDestination) {
        this.shipmentDestination = shipmentDestination;
    }

    // public hashCode function
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.description);
        hash = 47 * hash + Objects.hashCode(this.shipmentName);
        hash = 47 * hash + Objects.hashCode(this.shipmentDestination);
        return hash;
    }

    // public toString function
    @Override
    public String toString() {
        return "ShipmentQuest{" + "description=" + description + ", shipmentName=" + shipmentName + ", shipmentDestination=" + shipmentDestination + '}';
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
        final ShipmentQuest other = (ShipmentQuest) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.shipmentName, other.shipmentName)) {
            return false;
        }
        if (!Objects.equals(this.shipmentDestination, other.shipmentDestination)) {
            return false;
        }
        return true;
    }
    
}
