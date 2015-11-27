/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.control;

import byui.cit260.theRevengeOfMerek.model.Game;
import byui.cit260.theRevengeOfMerek.model.InventoryItem;
import byui.cit260.theRevengeOfMerek.model.Location;
import byui.cit260.theRevengeOfMerek.model.Map;
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
        
        // If the package does not exist, add it to the players inventory
        if (!ShipmentQuestControl.shipmentQuestStarted(ShipmentQuestControl.getStartingLocationPackagesName(location))) {
            inventory.add(new InventoryItem("package",1.0,ShipmentQuestControl.getStartingLocationPackagesName(location)));
        }
        
    }
    
    // Validate the player has arrived with shipment
    public static void receiveShipmentFromInventory(Location location) {
        /* 
        Each item will have a designated start and end location, noted by the name of the package.
        When the player arrives at the location with the package in their inventory, this method
        will mark the quest at the previous location complete and remove the item from inventory.
        */
        
        // Declare variables
        String packagesName = ShipmentQuestControl.getEndingLocationPackagesName(location);
        
        // Check to see if the player started the quest and reward them if they have
        if (ShipmentQuestControl.shipmentQuestStarted(packagesName)) {
            for (InventoryItem.packages packages : InventoryItem.packages.values()) {
                if (packages.getName().equals(packagesName)) {
                    // Get the current game, map, and locations
                    Game game = TheRevengeOfMerek.getCurrentGame();
                    Map map = game.getMap();
                    Location[][] locations = map.getLocations();
                    
                    // Set quest status to complete for the starting location
                    locations[packages.getStarty()][packages.getStartx()].setQuestComplete(true);
                    System.out.println("Thank you so much for getting this package to us!\n"
                                     + "Quest Complete!");
                }
            }
        }
        
    }
    
    // Verify if the player is already on this quest
    public static boolean shipmentQuestStarted(String packagesName) {
        
        // Acquire player's inventory list and declare other variables
        ArrayList<InventoryItem> inventory = TheRevengeOfMerek.getCurrentGame().getInventory();
        String name;
        String inventoryType;
        boolean exists = false;
        
        // Check player's inventory for existing packages
        for (InventoryItem inventoryItem: inventory) {
            name = inventoryItem.getName();
            inventoryType = inventoryItem.getInventoryType();
            if (inventoryType.equals("package")) {
                if (name.equals(packagesName)) {
                    exists = true;
                }
            }
        }
        
        return exists;
    }
    
    public static String getStartingLocationPackagesName(Location location) {
        
        // Declare variables
        String packagesName = "";
        
        // Add the appropriate item to their inventory
        if (location.getColumn()==0 & location.getRow()==0) {
            packagesName = InventoryItem.packages.package00.getName();
        } else if (location.getColumn()==1 & location.getRow()==4) {
            packagesName = InventoryItem.packages.package14.getName();
        } else if (location.getColumn()==2 & location.getRow()==2) {
            packagesName = InventoryItem.packages.package22.getName();
        } else if (location.getColumn()==3 & location.getRow()==4) {
            packagesName = InventoryItem.packages.package34.getName();
        } else if (location.getColumn()==4 & location.getRow()==4) {
            packagesName = InventoryItem.packages.package44.getName();
        }
        
        return packagesName;
    }
    
    public static String getEndingLocationPackagesName(Location location) {
        
        // Declare variables
        String packagesName = "";
        
        // Add the appropriate item to their inventory
        if (location.getColumn()==0 & location.getRow()==2) {
            packagesName = InventoryItem.packages.package00.getName();
        } else if (location.getColumn()==0 & location.getRow()==4) {
            packagesName = InventoryItem.packages.package14.getName();
        } else if (location.getColumn()==3 & location.getRow()==1) {
            packagesName = InventoryItem.packages.package22.getName();
        } else if (location.getColumn()==2 & location.getRow()==3) {
            packagesName = InventoryItem.packages.package34.getName();
        } else if (location.getColumn()==4 & location.getRow()==3) {
            packagesName = InventoryItem.packages.package44.getName();
        }
        
        return packagesName;
    }
    
}
