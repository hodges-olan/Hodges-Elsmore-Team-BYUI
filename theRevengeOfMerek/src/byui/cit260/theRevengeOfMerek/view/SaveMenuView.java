/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import java.util.Scanner;

/**
 *From the Game Play Menu, the user will select the Save option.  This will bring up this menu, which will 

ask them if they wish to save their current progress. 

 If yes, the player is prompted to enter the location of the file where they want to save the game. Then it 

will save their progress and return them back to the Game Play Menu.  If an invalid file location is 

entered an error message is displayed and the player is prompted to enter a valid file name again. 

If no, it will not save their progress and return them back to the Game Play Menu.
 * @author maryelsmore
 */
public class SaveMenuView {
    
    // Declare MENU Constant Variable
    private final String MENU = "\n"
        + "\n-----------------------------------"
        + "\n|Do you wish to save your progress?|"
        + "\n|----------------------------------|"
        + "\n| (Y)es                            |"
        + "\n| (E)xit                           |"
        + "\n|----------------------------------|";
    
    // Method to display the save menu
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
            System.out.println("Select an Option on the Save Menu");
            
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
            case 'Y':
                this.displaySaveProgram();
                break;
            case 'E':
                return;
            default:
                System.out.println("\n Invalid Selection, Try Again");
                break;
        }
    }

    private void displaySaveProgram() {
        // Display where to Save Game
        System.out.println("\n"
                + "\n------------------------------------"
                + "\n|            Save Game             |"
                + "\n|----------------------------------|"
                + "\n| Please enter the location you    |"
                + "\n| would like to save your game:    |"
                + "\n|                                  |"
                + "\n-----------------------------------|"
                + "\n\nPress any key to return to the Save Menu");
        
        // Wait for the user to press any key
        String input = null;
        Scanner keyboard = new Scanner(System.in);
        input = keyboard.nextLine();
        
        // Return to the help menu
        return;
        
    }


}