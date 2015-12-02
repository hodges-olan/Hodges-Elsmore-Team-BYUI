/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import therevengeofmerek.TheRevengeOfMerek;

/**
 *
 * @author co075oh
 */
public class BattleControlView {
    
    // Declare MENU Constant Variable
    private final String MENU = "\n"
            + "\n-----------------------------------"
            + "\n|          Battle Menu            |"
            + "\n-----------------------------------"
            + "\n| (P)ummel                        |"
            + "\n| (H)eroic Strike                 |"
            + "\n| (C)harge                        |"
            + "\n| (B)andage                       |"
            + "\n| (F)lee                          |"
            + "\n-----------------------------------";
    private final BufferedReader keyboard = TheRevengeOfMerek.getInFile();
    private final PrintWriter console = TheRevengeOfMerek.getOutFile();
    
    // Method to display the main menu
    public void displayMenu() {
        
        // Declare variables
        char selection = ' ';
        
        // Loop to show and gather input from user in main menu
        do {
            // Print the main menu
            this.console.println(MENU);
            
            // Gather input from the player
            String input = this.getInput();
            
            // Gather the first char from the input and capitalize it
            selection = Character.toUpperCase(input.charAt(0));
            
            // Invoke the switches to execute the appropriate action
            selection = this.doAction(selection);
       
        } while (selection != 'F' & selection != 'C' & selection != 'D');
        
        if (selection == 'F') {
            this.console.println("You have fled!");
        } else if (selection == 'C') {
            this.console.println("You have won!");
        } else {
            this.console.println("You have been defeated!");
        }
        
    }

    // Method to gather the input from the user 
    private String getInput() {
        
        // Declare variables for getInput method
        boolean valid = false;
        String input = null;
        
        // Loop to gather input from user until they give valid input
        do { 
            this.console.println("Select an Option on the Battle Menu");
            
            try {
                input = this.keyboard.readLine();
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Invalid option - please select from the Menu Above");
            }
            input = input.trim();
            
            if (input.length() == 0 || input.length() > 1) {
                ErrorView.display(this.getClass().getName(), "Invalid option - please select from the Menu Above");
            } else {
                valid = true;
            }
        
        } while(!valid);
        
        return input;
    } 
    
    // Execute the appropriate action based on input from user
    private char doAction(char selection) {
        switch(selection) {
            case 'P':
                this.pummel();
                break;
            case 'H':
                this.heroicStrike();
                break;
            case 'C':
                this.charge();
                break;
            case 'B':
                this.bandage();
                break;
            case 'F':
                String verify = this.flee();
                selection = Character.toUpperCase(verify.charAt(0));
                if (selection == 'Y') {
                    return 'F';
                } else {
                    return ' ';
                }
            default:
                ErrorView.display(this.getClass().getName(), "Invalid Selection, Try Again");
                break;
        }
        return ' ';
    }   

    private void pummel() {
        this.console.println("Pummel!");
    }

    private void heroicStrike() {
        this.console.println("Heroic Strike!");
    }

    private void charge() {
        this.console.println("Charge!");
    }

    private void bandage() {
        this.console.println("Bandage!");
    }

    private String flee() {
        // Declare variables for getInput method
        boolean valid = false;
        String input = null;

        // Loop to gather input from user until they give valid input
        do {
            this.console.println("Are you sure?  (Y/N)");

            try {
                input = this.keyboard.readLine();
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Invalid option - please select Y or N");
            }
            input = input.trim();

            if (input.length() == 0 || input.length() > 1) {
                ErrorView.display(this.getClass().getName(), "Invalid option - please select Y or N");
            } else {
                valid = true;
            }

        } while (!valid);

        return input;
    }
    
}
