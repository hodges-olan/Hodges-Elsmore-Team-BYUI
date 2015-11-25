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
    
    // Constructor Method for StartProgramView Class
    public StartProgramView() {
    }
    
    // Method to start the program
    public void startProgram() {
        
        // Display the opening banner
        this.displayBanner();
        
        // Get the players name
        String playersName = this.getPlayersName();
        
        // Create a new Player instance from the player's name
        Player player = GameControl.createNewPlayer(playersName);
        
        // Display the welcome message
        this.displayWelcomeMessage(player);
        
        // Display the main menu
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.display();
        
    }

    // Method to display the welcome banner
    private void displayBanner() {
        System.out.println("\n"
                + "\n*********************************************************************"
                + "\n*             Welcome to The Revenge of Merek                       *"
                + "\n*********************************************************************"
                + "\n* In Revenge of Merek, you are the child of King Merek. He ruled    *"
                + "\n* over the land of Afenara and was regarded as a loving and wise    *"
                + "\n* king. But, the evil Orc Worthag has decided it was his turn at    *"
                + "\n* the helm and overthrew King Merek as leader.                      *"
                + "\n*                                                                   *"
                + "\n* The land of Afenara and its people are now suffering under the    *"
                + "\n* rule of Worthag and you seek to gain the throne back for your     *"
                + "\n* father. To do so, you will need to seek out support from the      *"
                + "\n* Lords of each of the five counties across the land.  By gaining   *"
                + "\n* their trust by performing quests for them you can bolster your    *"
                + "\n* forces and win back the kingdom from Worthag and establish King   *"
                + "\n* Merek as a righteous ruler over the land again.                   *"
                + "\n*                                                                   *"
                + "\n* These quests will involve recovering valuable lost artifacts from *"
                + "\n* bandits, to solving complex situations that the villages might be *"
                + "\n* in.  Once each of the five quests have been completed in each of  *"
                + "\n* the five counties, you will then have all the forces you need to  *"
                + "\n* dethrone Worthag and win the game!                                *"
                + "\n*********************************************************************");
    }

    // Method to gather input from user for their name
    private String getPlayersName() {
        boolean valid = false;
        String playersName = null;
        Scanner keyboard = new Scanner(System.in);
        
        do { 
            System.out.println("Enter the player's name below");
            
            playersName = keyboard.nextLine();
            playersName = playersName.trim();
            
            if (playersName.length() < 2) {
                System.out.println("Invalid name - the name must be over one character long");
            } else {
                valid = true;
            }
        
        } while(!valid);
        
        return playersName;
    } 

    // Method for displaying the welcome message to the user
    private void displayWelcomeMessage(Player player) {
        int length = player.getName().length();
        int space = (40 - length)/2;
        System.out.println("\n\n========================================"
                + "\n          Welcome to the game");
        for (int i = 0; i < space; i++) {
            System.out.print(" ");
        }
        System.out.print(player.getName());
        System.out.println("\n               Have fun!"
                + "\n========================================");
    }
    
}


