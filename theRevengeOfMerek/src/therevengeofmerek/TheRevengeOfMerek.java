/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package therevengeofmerek;

import byui.cit260.theRevengeOfMerek.model.Character;
import byui.cit260.theRevengeOfMerek.model.Game;
import byui.cit260.theRevengeOfMerek.model.Player;
import byui.cit260.theRevengeOfMerek.view.StartProgramView;

/**
 *
 * @author maryelsmore
 */
public class TheRevengeOfMerek {

    private static Game currentGame = null;
    private static Player player = null;
    
    public static void main(String[] args) {
       StartProgramView startProgramView = new StartProgramView();
       startProgramView.startProgram();
    }
    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        TheRevengeOfMerek.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        TheRevengeOfMerek.player = player;
    }
}