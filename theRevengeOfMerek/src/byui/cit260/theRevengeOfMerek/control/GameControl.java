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

    public static Player createNewPlayer(String playersName) {
        
        if (playersName == null) {
            return null;
        }
        Player player = new Player();
        player.setName(playersName);
        
        TheRevengeOfMerek.setPlayer(player);
        
        return player;
        
        
        
    }
    
}
