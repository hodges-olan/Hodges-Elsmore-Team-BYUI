/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import byui.cit260.theRevengeOfMerek.control.ShipmentQuestControl;
import byui.cit260.theRevengeOfMerek.exceptions.ShipmentQuestControlException;
import byui.cit260.theRevengeOfMerek.model.Location;
import java.util.Scanner;

/**
 *
 * @author co075oh
 */
public class ShipmentQuestView {

    // Declare MENU Constant Variable
    private final String MENU = "\n"
                + "\n*********************************************************************"
                + "\n*                         Shipment Quest                            *"
                + "\n*********************************************************************"
                + "\n* We are so glad that you have come!  We have a shipment which      *"
                + "\n* we need to reach it's destination as soon as possible!  You would *"
                + "\n* be a great help if you could take it for us.  Could you please    *"
                + "\n* help us?                                                          *"
                + "\n*********************************************************************";
    
    // Method to display the welcome banner
    public void displayMenu(Location location) {
        
        // Declare variables
        char selection = ' ';
        
        // Check to see if the player has already started this particular quest for a given location
        if (!ShipmentQuestControl.shipmentQuestStarted(location)) {
            // Loop to show and gather input from user in main menu
            do {
                // Print the main menu
                System.out.println(MENU);

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
                    } catch (ShipmentQuestControlException sce) {
                        // Display error message for invalid input, reset selection, and try again.
                        System.out.println(sce.getMessage());
                        selection = ' ';
                    }
                } catch (IndexOutOfBoundsException ioo) {
                    // Display error message for invalid input, reset selection, and try again.
                    System.out.println("Invalid option - please select Y or N");
                    selection = ' ';
                }

            } while ((selection != 'N') & (selection != 'C'));

            if (selection == 'C') {
                System.out.println("Thank you!  Don't forget to drop the shipment off to get your reward.\n"
                                 + "Don't forget to check the package destination in your inventory.");
            }
        } else {
            System.out.println("Don't forget to drop the package off!\n"
                             + "If you forget where it needs to go, check your inventory.");
        }
        
        
    }

    // Method to gather the input from the user 
    private String getInput(String message) {
        
        // Declare variables for getInput method
        String input;
        Scanner keyboard = new Scanner(System.in);
        
        // Loop to gather input from user until they give valid input
        System.out.println(message);
        input = keyboard.nextLine();
        input = input.trim();
            
        return input;
    }

    // Execute the appropriate action based on input from user
    private char doAction(char selection, Location location) throws ShipmentQuestControlException {
        
        // Declare variables
        char verify;
        
        // Logical tree for starting the quest or verifying if the user wants to exit
        if (selection == 'Y') {
            // Start Quest
            ShipmentQuestControl.addShipmentToInventory(location);
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
                        throw new ShipmentQuestControlException ("Invalid option - please select Y or N");
                    }
                } catch (IndexOutOfBoundsException ioo) {
                    throw new ShipmentQuestControlException("Invalid option - please select Y or N");
                } 
            } while (selection != 'N' & selection != ' ');
        } else {
            // Display invalid input error and go back to ask them if they want to accept the quest
            throw new ShipmentQuestControlException ("Invalid option - please select Y or N");
        }
        return selection;
    }
    
}
