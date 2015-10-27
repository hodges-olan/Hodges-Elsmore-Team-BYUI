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
public class MainMenuView {
    
    // Declare MENU Constant Variable
    private final String MENU = "\n"
            + "\n-----------------------------------"
            + "\n|           Main Menu             |"
            + "\n-----------------------------------"
            + "\n| (N)ew Game                      |"
            + "\n| (S)ave Game                     |"
            + "\n| (C)ontinue Game                 |"
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
            System.out.println("Select an Option on the Main Menu");
            
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
            case 'N':
                this.startNewGame();
                break;
            case 'S':
                this.saveGame();
                break;
            case 'C':
                this.retrieveGame();
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

    // Method to start a new game
    private void startNewGame() {
        System.out.println("The startNewGame method was called!");
    }

    // Method to retrieve a saved game
    private void retrieveGame() {
        System.out.println("The retrieveGame method was called!");
    }

    // Method to display the help menu
    private void displayHelpMenu() {
        System.out.println("The displayHelpMenu method was called!");
    }

    // Method to save a game
    private void saveGame() {
        System.out.println("The saveGame method was called!");
    }
       
}
