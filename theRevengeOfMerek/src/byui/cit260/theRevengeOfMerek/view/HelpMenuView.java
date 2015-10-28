/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import java.util.Scanner;

/**
 *
 * @author co075oh
 */
class HelpMenuView {

    // Declare MENU Constant Variable
    private final String MENU = "\n"
        + "\n-----------------------------------"
        + "\n|           Help Menu             |"
        + "\n|---------------------------------|"
        + "\n| (G)oal of the game              |"
        + "\n| (U)ser Console - Game Console   |"
        + "\n| (E)xit                          |"
        + "\n|---------------------------------|";
    
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
            System.out.println("Select an Option on the Help Menu");
            
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
            case 'G':
                this.displayGoalHelp();
                break;
            case 'U':
                this.displayUserConsoleHelp();
                break;
            case 'E':
                return;
            default:
                System.out.println("\n Invalid Selection, Try Again");
                break;
        }
    }

    private void displayGoalHelp() {
        
        // Display the Goal of the Game help text
        System.out.println("\n"
                + "\n------------------------------------"
                + "\n|         Goal of the Game         |"
                + "\n|----------------------------------|"
                + "\n| To seat Merek back in his throne |"
                + "\n| you will need to complete all    |"
                + "\n| five quests in all five counties |"
                + "\n| which will gain you trust with   |"
                + "\n| each Lord.                       |"
                + "\n| Once you have gained the trust   |"
                + "\n| of all five Lords, you will then |"
                + "\n| have the necessary forces to     |"
                + "\n| overthrow Worthag and beat the   |"
                + "\n| game.                            |"
                + "\n-----------------------------------|"
                + "\n\nPress any key to return to the Help menu");
        
        // Wait for the user to press any key
        String input = null;
        Scanner keyboard = new Scanner(System.in);
        input = keyboard.nextLine();
        
        // Return to the help menu
        return;
        
    }
    
    private void displayUserConsoleHelp() {
        System.out.println("Goal Help");
    }

}