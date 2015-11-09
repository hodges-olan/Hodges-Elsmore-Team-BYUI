/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import java.util.Scanner;

/**
 *
 * @author maryelsmore
 */
public class GameMenuView {

    
    // Declare MENU Constant Variable
    private final String MENU = "\n"
            + "\n-----------------------------------"
            + "\n|           Game Menu             |"
            + "\n-----------------------------------"
            + "\n| (I)nventory                     |"
            + "\n| (Q)uests                        |"
            + "\n| (M)ove                          |"
            + "\n| (S)ave                          |"
            + "\n| (H)elp                          |"
            + "\n| (E)xit                          |"
            + "\n-----------------------------------";
    
    // Method to display the main menu
    void displayMenu() {
        
        // Declare variables
        char selection = ' ';
        
        // Loop to show and gather input from user in main menu
        do {
            // Print the main menu
            System.out.println(MENU);
            
            // Gather input from the player
            String input = this.getInput();
            
            // Gather the first char from the input and capitalize it
            selection = Character.toUpperCase(input.charAt(0));
            
            // Invoke the switches to execute the appropriate action
            this.doAction(selection);
       
        } while (selection != 'E');
        
    }

    // Method to gather the input from the user 
    private String getInput() {
        
        // Declare variables for getInput method
        boolean valid = false;
        String input = null;
        Scanner keyboard = new Scanner(System.in);
        
        // Loop to gather input from user until they give valid input
        do { 
            System.out.println("Select an Option on the Game Menu");
            
            input = keyboard.nextLine();
            input = input.trim();
            
            if (input.length() == 0 || input.length() > 1) {
                System.out.println("Invalid option - please select from the Menu Above");
            } else {
                valid = true;
            }
        
        } while(!valid);
        
        return input;
    } 
    
    // Execute the appropriate action based on input from user
    private void doAction(char selection) {
        switch(selection) {
            case 'I':
                this.displayinventory();
                break;
            case 'Q':
                this.displayQuests();
                break;
            case 'M':
                this.movePlayer();
                break;
            case 'S':
                this.saveGame();
                break;
            case 'H':
                this.displayHelpMenu();
                break;
            case 'E':
                return;
            default:
                System.out.println("\n Invalid Selection, Try Again");
                break;
        }
    }

    // Display the players inventory    
    private void displayinventory() {
        System.out.println("The displayInventory method was called!");
    }
    
    //Display Game Quests
    private void displayQuests() {
        System.out.println("The displayQuests method was called!");
    }

    // Method to move Player
    private void movePlayer() {
        System.out.println("The movePlayer method was called!");
    }

    // Method to save a game
    private void saveGame() {
        
        //Create and display the save menu
        SaveMenuView saveMenu = new SaveMenuView();
        saveMenu.displayMenu();
    }
    
    // Method to display the help menu
    private void displayHelpMenu() {
        
        // Create and display the game menu
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
        
    }
 
       
}
