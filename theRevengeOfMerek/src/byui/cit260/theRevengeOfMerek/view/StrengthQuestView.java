/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import byui.cit260.theRevengeOfMerek.exceptions.StrengthQuestControlException;
import byui.cit260.theRevengeOfMerek.model.ArtifactStrengthQuest;
import byui.cit260.theRevengeOfMerek.model.Location;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import therevengeofmerek.TheRevengeOfMerek;

/*To prove your strength, the Lord asks you to duel his best warrior.  This will initialize the Battle menu in
 *which you will engage the warrior.  If you defeat the warrior, you will complete the quest and gain more 
 *of the Lord’s trust.
 */

/**
 *
 * @author maryelsmore
 */
public class StrengthQuestView {

    // Declare MENU Constant Variable
    private final String MENU = "\n"
                + "\n*********************************************************************"
                + "\n*                         Strength Quest                            *"
                + "\n*********************************************************************"
                + "\n* It's time to prove your strength!  We would like you to duel      *"
                + "\n* the best warrior from our country to show how strong you are.     *"
                + "\n*                                                                   *"
                + "\n* Are you up for the challenge?                                     *"
                + "\n*********************************************************************";
    private final BufferedReader keyboard = TheRevengeOfMerek.getInFile();
    private final PrintWriter console = TheRevengeOfMerek.getOutFile();
    
    // Method to display the welcome banner
    public void displayMenu(Location location) {
        
        // Declare variables
        char selection = ' ';
        
        // Loop to show and gather input from user in main menu
        do {
            // Print the main menu
            this.console.println(MENU);
            
            // Gather input from the player
            String input = this.getInput("Do you accept the quest?  (Y/N)");
            
            // Gather the first char from the input and capitalize it
            try {
                // Trim input to just the first character
                selection = Character.toUpperCase(input.charAt(0));
                
                // Invoke the switches to execute the appropriate action
                try {
                    // Invoke the doAction method
                    selection = this.doAction(selection, location);
                } catch (StrengthQuestControlException sce) {
                    //Display Error message for invalid input, reset selection, and try again
                    ErrorView.display(this.getClass().getName(), sce.getMessage());
                    selection = ' ';
                }
            } catch (IndexOutOfBoundsException ioo) {
                // Display error message for invalid input, reset selection, and try again.
                ErrorView.display(this.getClass().getName(), "Invalid option - please select Y or N");
                selection = ' ';
            }
       
        } while ((selection != 'N') & (selection != 'C'));
        
        if (selection == 'C') {
            this.console.println("Quest Complete!");
        }
        
    }
    
    // Method to gather the input from the user 
    private String getInput(String message) {
        
        // Declare variables for getInput method
        String input = null;
        
        // Loop to gather input from user until they give valid input
        this.console.println(message);
        try {
            input = this.keyboard.readLine();
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), "Invalid option - please select Y or N");
        }
        input = input.trim();
            
        return input;
    }
    
    // Execute the appropriate action based on input from user
    private char doAction(char selection, Location location) throws StrengthQuestControlException {
        
        // Declare variables
        char verify;
        
        // Logical tree for starting the quest or verifying if the user wants to exit
        if (selection == 'Y') {
            // Start Quest
            this.startNewStrengthQuest(location);
            selection = 'C';
        } else if (selection == 'N') {
            // Verify users selection
            do {
                String input = this.getInput("Are you sure?  (Y/N)");
                try {
                    verify = Character.toUpperCase(input.charAt(0));
                    if (verify == 'Y') {
                        selection = 'N';
                    } else if (verify == 'N') {
                        selection = ' ';
                    } else {
                        throw new StrengthQuestControlException ("Invalid option - please select Y or N");
                    }
                } catch (IndexOutOfBoundsException ioo) {
                    throw new StrengthQuestControlException("Invalid option - please select Y or N");
                }   
            } while (selection != 'N' & selection !=' ');
        } else {
            // Display invalid input error and go back to ask them if they want to accept the quest
            throw new StrengthQuestControlException("Invalid option - please select Y or N");
        }
        return selection;    
    }


    private void startNewStrengthQuest(Location location) {
       // Initialize Variables
        ArtifactStrengthQuest artifactStrengthQuest = location.getStrengthQuest();
    }
}  

