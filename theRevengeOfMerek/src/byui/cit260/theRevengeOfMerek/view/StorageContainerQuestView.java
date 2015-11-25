/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import byui.cit260.theRevengeOfMerek.control.StorageContainerQuestControl;
import byui.cit260.theRevengeOfMerek.exceptions.StorageContainerQuestControlException;
import byui.cit260.theRevengeOfMerek.model.Location;
import byui.cit260.theRevengeOfMerek.model.StorageContainerQuest;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author co075oh
 */
public class StorageContainerQuestView {

    // Declare MENU Constant Variable
    private final String MENU = "\n"
                + "\n*********************************************************************"
                + "\n*                    Storage Container Quest                        *"
                + "\n*********************************************************************"
                + "\n* We are so glad that you have come!  We have a shipment which      *"
                + "\n* we need to put into a container for safe keeping during it's      *"
                + "\n* journey.  Could you please help us?                               *"
                + "\n*********************************************************************";
    
    // Method to display the welcome banner
    public void displayMenu(Location location) {
        
        // Declare variables
        char selection = ' ';
        
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
                } catch (StorageContainerQuestControlException sce) {
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
            System.out.println("Quest Complete!");
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
    private char doAction(char selection, Location location) throws StorageContainerQuestControlException {
        
        // Declare variables
        char verify;
        
        // Logical tree for starting the quest or verifying if the user wants to exit
        if (selection == 'Y') {
            // Start Quest
            this.startNewStorageContainerQuest(location);
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
                        throw new StorageContainerQuestControlException ("Invalid option - please select Y or N");
                    }
                } catch (IndexOutOfBoundsException ioo) {
                    throw new StorageContainerQuestControlException("Invalid option - please select Y or N");
                } 
            } while (selection != 'N' & selection != ' ');
        } else {
            // Display invalid input error and go back to ask them if they want to accept the quest
            throw new StorageContainerQuestControlException ("Invalid option - please select Y or N");
        }
        return selection;
    }

    private void startNewStorageContainerQuest(Location location) {
        
        // Initialize Variables
        StorageContainerQuest storageContainerQuest = location.getStorageContainerQuest();
        double reqVolume = storageContainerQuest.getRequiredVolume();
        
        // Initialize random volume requirement between 400 and 10
        if (reqVolume == 0.0) {
            Random rand = new Random();
            reqVolume = rand.nextInt((400-10)+1)+10;
        } else {
            reqVolume = storageContainerQuest.getRequiredVolume();
        }
        
        while (!location.isQuestComplete()) {
            System.out.println("We need a barrel that will fit " + reqVolume + " square feet of water.\n"
                             + "Use the equation for the volume of a cylinder to get the appropriate measurements.");
            double radius = this.getInputDouble("radius");
            double height = this.getInputDouble("height");
            StorageContainerQuestControl instance = new StorageContainerQuestControl();
            try {
                instance.calculateVolume(radius, height, reqVolume);
                System.out.println("That will fit the requirements exactly!  Thank you!");
                storageContainerQuest.setHeight(height);
                storageContainerQuest.setRadius(radius);
                location.setQuestComplete(true);
            } catch (StorageContainerQuestControlException sce) {
                System.out.println(sce.getMessage());
            }
            
        }
        
    }

    private Double getInputDouble(String dimension) {
        Double value = null;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is the " + dimension + " we should use?");
        String input;
        
        while (value == null) {
            try {
                // parse and convert number from text to double
                input = keyboard.nextLine();
                value = Double.parseDouble(input);
            } catch (NumberFormatException nf) {
                System.out.println("\nYou must enter a valid number. Please try again.");
            }
        }
            
        return value;
    }
    
}
