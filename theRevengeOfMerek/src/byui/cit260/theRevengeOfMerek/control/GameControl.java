/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.control;

import byui.cit260.theRevengeOfMerek.model.Game;
import byui.cit260.theRevengeOfMerek.model.InventoryItem;
import byui.cit260.theRevengeOfMerek.model.Map;
import byui.cit260.theRevengeOfMerek.model.Player;
import java.util.ArrayList;
import therevengeofmerek.TheRevengeOfMerek;

/**
 *
 * @author co075oh
 */
public class GameControl {

    // Create the player from the name given
    public static Player createNewPlayer(String playersName) {
        
        // Error checking
        if (playersName == null) {
            return null;
        }
        
        // Create new player instance
        Player player = new Player();
        
        // Set the name to the value given
        player.setName(playersName);
        
        // Save the player instance to the main class
        TheRevengeOfMerek.setPlayer(player);
        
        // Return the player instance created
        return player;
        
    }

    public static void createNewGame(Player player) {
        
        // Create new game
        Game game = new Game();
        
        // Save the game in TheRevengeOfMerek
        TheRevengeOfMerek.setCurrentGame(game);
        
        // Save player in game
        game.setPlayer(player);
        
        // Create the inventory list and save in the game
        ArrayList<InventoryItem> inventoryList = GameControl.createInventoryList();
        game.setInventory(inventoryList);
        
        // Create the map and save in the game
        Map map = MapControl.createMap();
        game.setMap(map);
        
        // Move actors to their starting positions in the map
        MapControl.moveCharactersToStartingLocations(map);
        
    }

    private static ArrayList<InventoryItem> createInventoryList() {
        
        // Create starter list of items in inventory
        ArrayList<InventoryItem> inventory = new ArrayList<>();
        
        inventory.add(new InventoryItem("bandage",2.0,InventoryItem.bandage.linen.getName()));
        inventory.add(new InventoryItem("potion",2.0,InventoryItem.potion.lesser.getName()));
        inventory.add(new InventoryItem("weapon",1.0,InventoryItem.weapon.venomSilverAxe.getName()));
        inventory.add(new InventoryItem("armor",1.0,InventoryItem.armor.birthOfTheCrown.getName()));
        inventory.add(new InventoryItem("shield",1.0,InventoryItem.shield.championShield.getName()));

        // Return Inventory List
        return inventory;
        
    }
    
}