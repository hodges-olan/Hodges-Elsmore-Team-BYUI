/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.control;

import byui.cit260.theRevengeOfMerek.model.Player;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
