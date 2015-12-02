/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.control;

import byui.cit260.theRevengeOfMerek.exceptions.GameControlException;
import byui.cit260.theRevengeOfMerek.model.Game;
import byui.cit260.theRevengeOfMerek.model.InventoryItem;
import byui.cit260.theRevengeOfMerek.model.Map;
import byui.cit260.theRevengeOfMerek.model.Player;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
        
        // Set the name to the value given and set health
        player.setName(playersName);
        player.setHealth(100);
        
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
        
        inventory.add(new InventoryItem("bandage",2.0,InventoryItem.bandage.bandage.getName()));
        inventory.add(new InventoryItem("potion",2.0,InventoryItem.potion.potion.getName()));
        inventory.add(new InventoryItem("weapon",1.0,InventoryItem.weapon.venomSilverAxe.getName()));
        
        // Equip Character with original equipment
        Game game = TheRevengeOfMerek.getCurrentGame();
        Player player = game.getPlayer();
        player.setArmor("None");
        player.setShield("None");
        player.setWeapon("Venom Silver Axe");

        // Return Inventory List
        return inventory;
        
    }

    public static void saveGame(Game currentGame, String filepath) throws GameControlException {
        
        try (FileOutputStream fops = new FileOutputStream(filepath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            output.writeObject(currentGame);
        } catch (IOException e) {
            throw new GameControlException(e.getMessage());
        }
        
    }

    public static void continueGame(String filePath) throws GameControlException {
        
        Game game = null;
        
        try (FileInputStream fips = new FileInputStream(filePath)) {
            ObjectInputStream output = new ObjectInputStream(fips);
            game = (Game) output.readObject();
        } catch (FileNotFoundException fnfe) {
            throw new GameControlException(fnfe.getMessage());
        } catch (Exception e) {
            throw new GameControlException(e.getMessage());
        }
        
        TheRevengeOfMerek.setCurrentGame(game);
        
    }
    
}