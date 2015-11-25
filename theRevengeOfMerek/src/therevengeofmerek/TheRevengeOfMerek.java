/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package therevengeofmerek;

import byui.cit260.theRevengeOfMerek.model.Game;
import byui.cit260.theRevengeOfMerek.model.Player;
import byui.cit260.theRevengeOfMerek.view.StartProgramView;

/**
 *
 * @author maryelsmore
 */
public class TheRevengeOfMerek {

    // Variable declaration
    private static Game currentGame = null;
    private static Player player = null;
    
    // Main Method for TheRevengeOfMerek Game
    public static void main(String[] args) {
       StartProgramView startProgramView = new StartProgramView();
       try {
           // Create StartProgramView and start the program
           startProgramView.startProgram();
       } catch (Throwable te) {
           System.out.println(te.getMessage());
           te.printStackTrace();
           startProgramView.startProgram();
       }
    }
    
    // Getter method for currentGame
    public static Game getCurrentGame() {
        return currentGame;
    }

    // Setter method for currentGame
    public static void setCurrentGame(Game currentGame) {
        TheRevengeOfMerek.currentGame = currentGame;
    }

    // Getter method for Player
    public static Player getPlayer() {
        return player;
    }

    // Setter method for Player
    public static void setPlayer(Player player) {
        TheRevengeOfMerek.player = player;
    }
}