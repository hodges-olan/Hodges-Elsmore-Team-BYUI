/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.control;

import byui.cit260.theRevengeOfMerek.model.InventoryItem;
import byui.cit260.theRevengeOfMerek.model.Location;
import java.util.ArrayList;
import therevengeofmerek.TheRevengeOfMerek;

/**
 *
 * @author co075oh
 */
public class ShipmentQuestControl {
    
    // Class to add the appropriate shipment item to the player's inventory
    public static void addShipmentToInventory(Location location) {
        
        // Acquire player's inventory list
        ArrayList<InventoryItem> inventory = TheRevengeOfMerek.getCurrentGame().getInventory();
        
        // Add the appropriate item to their inventory
        // Still need to modify this so that it selects the appropriate package based on the received location
        inventory.add(new InventoryItem("package",1.0,"Package"));
        
    }
    
    // Validate the player has arrived with shipment
    public static void receiveShipmentFromInventory(Location location) {
        /* 
        Fill this out, and it will need to be checked each time the players moves to a new location,
        regardless of whether they have already accepted a shipment quest or not.
        Each item will have a designated start and end location, noted by the name of the package.
        When the player arrives at the location with the package in their inventory, this method
        will mark the quest at the previous location complete and remove the item from inventory.
        */
    }
    
}
