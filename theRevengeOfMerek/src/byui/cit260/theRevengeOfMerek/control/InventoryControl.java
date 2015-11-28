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
    
    public static void addItemToInventory(String inventoryType, double quantity, String name) {
        
        // Acquire player's inventory list
        ArrayList<InventoryItem> inventory = TheRevengeOfMerek.getCurrentGame().getInventory();
        
        // Add the item to the player's inventory
        inventory.add(new InventoryItem(inventoryType, quantity, name));
        
    }
    
    public static void removeItemFromInventory(String inventoryType, double quantity, String name) throws InventoryControlException {
        
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
        
        // If the item was found, decrement the quantity or remove it entirely if it's all used.  Else throw an exception
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
    
    public static void useHealthPotion() throws InventoryControlException {
        // Get current player, their current health, and figure out how much you can heal them by
        Player player = TheRevengeOfMerek.getPlayer();
        double health = player.getHealth();
        double maxHeal = 100 - health;
        int index = -1;
        InventoryItem modifyInventoryItem;
        
        // Acquire player's inventory list
        ArrayList<InventoryItem> inventory = TheRevengeOfMerek.getCurrentGame().getInventory();
        
        // If they have a health potion, use it, otherwise, throw an InventoryControlException
        for (InventoryItem inventoryItem : inventory) {
            if (inventoryItem.getInventoryType().equals("potion")) {
                // Heal the player as much as possible
                if (InventoryItem.potion.potion.getHeal() >= maxHeal) {
                    player.setHealth(100);
                } else {
                    player.setHealth(health + InventoryItem.potion.potion.getHeal());
                }
                
                // Get the index of the item found
                index = inventory.indexOf(inventoryItem);
            }
        }
        
        // Remove the potion from inventory or throw error
        if (index != -1) {
            modifyInventoryItem = inventory.get(index);
            if (modifyInventoryItem.getQuantity() == 1) {
                inventory.remove(index);
            } else {
                modifyInventoryItem.setQuantity(modifyInventoryItem.getQuantity() - 1);
            }
        } else {
            throw new InventoryControlException("You do not have any potions to use!");
        }
    }
    
    public static void useBandage() throws InventoryControlException {
        // Get current player, their current health, and figure out how much you can heal them by
        Player player = TheRevengeOfMerek.getPlayer();
        double health = player.getHealth();
        double maxHeal = 100 - health;
        int index = -1;
        InventoryItem modifyInventoryItem;
        
        // Acquire player's inventory list
        ArrayList<InventoryItem> inventory = TheRevengeOfMerek.getCurrentGame().getInventory();
        
        // If they have a health potion, use it, otherwise, throw an InventoryControlException
        for (InventoryItem inventoryItem : inventory) {
            if (inventoryItem.getInventoryType().equals("bandage")) {
                // Heal the player as much as possible
                if (InventoryItem.bandage.bandage.getHeal() >= maxHeal) {
                    player.setHealth(100);
                } else {
                    player.setHealth(health + InventoryItem.bandage.bandage.getHeal());
                }
                
                // Get the index of the item found
                index = inventory.indexOf(inventoryItem);
            }
        }
        
        // Remove the potion from inventory or throw error
        if (index != -1) {
            modifyInventoryItem = inventory.get(index);
            if (modifyInventoryItem.getQuantity() == 1) {
                inventory.remove(index);
            } else {
                modifyInventoryItem.setQuantity(modifyInventoryItem.getQuantity() - 1);
            }
        } else {
            throw new InventoryControlException("You do not have any potions to use!");
        }
    }
    
    public static void equipItem(String was, String name) {
        
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
