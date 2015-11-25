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
public abstract class View implements ViewInterface {
    
    protected String promptMessage;

    public View(String promptMessage) {
        this.promptMessage = promptMessage;
    }
    
    public String getPromptMessage() {
        return promptMessage;
    }

    public void setPromptMessage(String promptMessage) {
        this.promptMessage = promptMessage;
    }
    
    // Method to display the main menu
    @Override
    public void display() {
        
        // Declare variables
        char selection = ' ';
        
        // Loop to show and gather input from user in main menu
        do {
            // Print the main menu
            System.out.println(this.promptMessage);
            
            // Gather input from the player
            String value = this.getInput();
            
            // Gather the first char from the input and capitalize it
            try {
                selection = Character.toUpperCase(value.charAt(0));
            } catch (IndexOutOfBoundsException ioo) {
                System.out.println("Invalid option - please select from the menu above");
            }
            
            // Invoke the switches to execute the appropriate action
            this.doAction(selection);
       
        } while (selection != 'E');
        
    }

    // Method to gather the input from the user 
    @Override
    public String getInput() {
        
        // Declare variables for getInput method
        boolean valid = false;
        String value = null;
        Scanner keyboard = new Scanner(System.in);
        
        // Loop to gather input from user until they give valid input
        while (!valid) { 
            System.out.println("Select an option on the menu above");
            
            value = keyboard.nextLine();
            value = value.trim();
            
            if (value.length() == 0 || value.length() > 1) {
                System.out.println("Invalid option - please select from the menu above");
            } else {
                valid = true;
            }
        
        }
        
        return value;
    }
    
}
