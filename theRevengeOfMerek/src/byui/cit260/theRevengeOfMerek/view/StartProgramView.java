/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import byui.cit260.theRevengeOfMerek.control.GameControl;
import byui.cit260.theRevengeOfMerek.model.Player;
import java.util.Scanner;

/**
 *
 * @author maryelsmore
 */
public class StartProgramView {
    public StartProgramView() {
        
    }
    public void startProgram() {
        
        this.displayBanner();
        
        String playersName = this.getPlayersName();
        
        Player player = GameControl.createNewPlayer(playersName);
        
        this.displayWelcomeMessage(player);
        
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.displayMenu();
        
    }

    private void displayBanner() {
        System.out.println("\n\n******************************************************************");
        
        System.out.println("*"
                + "\n* This is the game The Revenge of Merek"
                + "\n* In Revenge of Merek, you are the child of King Merek."
                + "\n* He rules over the land of Afenara and was"
                + "\n* regarded as a loving and wise king."
                + "\n* But, the evil Orc Worthag has decided it was his turn at the helm"
                + "\n* and overthrew King Merek as leader.");
        System.out.println("*"
                + "\n* The land of Afenara and its people are now suffering under the rule of Worthag"
                + "\n* and you seek to gain the throne back for your father."
                + "\n* To do so, you will need to seek out support from the Lords of each"
                + "\n* of the five counties across the land."
                + "\n* By gaining their trust by performing quests for them"
                + "\n* you can bolster your forces and win back the kingdom from Worthag"
                + "\n* and establish King Merek as a righteous ruler over the land again.");
        System.out.println("\n\n******************************************************************");
    }

    private String getPlayersName() {
        boolean valid = false;
        String playersName = null;
        Scanner keyboard = new Scanner(System.in);
        
        do { 
            System.out.println("Enter the player's name below");
            
            playersName = keyboard.nextLine();
            playersName = playersName.trim();
            
            if (playersName.length() < 2) {
                System.out.println("Invalid name - the name must be over two characters");
         
            } else {
                valid = true;
            }
        
        } while(!valid);
        return playersName;
    } 

    private void displayWelcomeMessage(Player player) {
        System.out.println("\n\n========================================");
        System.out.println("\tWelcome to the game " + player.getName());
        System.out.println("\tHave fun!");
        System.out.println("\n\n========================================");
    }
}


