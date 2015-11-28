/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.control;

import byui.cit260.theRevengeOfMerek.exceptions.InventoryControlException;
import byui.cit260.theRevengeOfMerek.model.InventoryItem;
import byui.cit260.theRevengeOfMerek.model.Player;
import java.util.ArrayList;
import therevengeofmerek.TheRevengeOfMerek;

/**
 *
 * @author maryreiko
 */
public class InventoryControl {
    
    public static void addItemToInventory (String inventoryType, double quantity, String name) {
        
        // Acquire player's inventory list
        ArrayList<InventoryItem> inventory = TheRevengeOfMerek.getCurrentGame().getInventory();
        
        // Add the item to the player's inventory
        inventory.add(new InventoryItem(inventoryType, quantity, name));
        
    }
    
    public static void removeItemFromInventory (String inventoryType, double quantity, String name) throws InventoryControlException {
        
        // Acquire player's inventory list and declare variables
        ArrayList<InventoryItem> inventory = TheRevengeOfMerek.getCurrentGame().getInventory();
        int index = -1;
        InventoryItem modifyInventoryItem;
        
        // Get the item from the player's inventory
        for (InventoryItem inventoryItem : inventory) {
            if (name.equals(inventoryItem.getName()) & inventoryType.equals(inventoryItem.getInventoryType())) {
                index = inventory.indexOf(inventoryItem);
            }
        }
        
        if (index != -1) {
            modifyInventoryItem = inventory.get(index);
        
            if (modifyInventoryItem.getQuantity() > quantity) {
                modifyInventoryItem.setQuantity(modifyInventoryItem.getQuantity()-quantity);
            } else if (modifyInventoryItem.getQuantity() == quantity) {
                inventory.remove(index);
            } else {
                throw new InventoryControlException("Sorry, you do not have enough of the items in your inventory.");
            }
        } else {
            throw new InventoryControlException("You do not have this item in your inventory");
        }
        
    }
    
    public static void useHealthPotion () {
        
    }
    
    public static void useBandage () {
        
    }
    
    public static void equipItem (String was, String name) {
        
        // Get current player
        Player player = TheRevengeOfMerek.getPlayer();
        
        // Equip weapon
        if (was.equals("weapon")) {
            player.setWeapon(name);
        }
        
        // Equip armor
        if (was.equals("armor")) {
            player.setArmor(name);
        }
        
        // Equip shield
        if (was.equals("shield")) {
            player.setShield(name);
        }
        
    }
    
}
