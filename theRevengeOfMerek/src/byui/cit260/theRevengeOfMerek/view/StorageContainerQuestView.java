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
            String input = this.getInput();
            
            // Gather the first char from the input and capitalize it
            selection = Character.toUpperCase(input.charAt(0));
            
            // Invoke the switches to execute the appropriate action
            selection = this.doAction(selection, location);
       
        } while ((selection != 'N') & (selection != 'C'));
        
        if (selection == 'C') {
            System.out.println("Quest Complete!");
        }
        
    }

    // Method to gather the input from the user 
    private String getInput() {
        
        // Declare variables for getInput method
        boolean valid = false;
        String input = null;
        Scanner keyboard = new Scanner(System.in);
        
        // Loop to gather input from user until they give valid input
        do { 
            System.out.println("Do you accept the quest?  (Y/N)");
            
            input = keyboard.nextLine();
            input = input.trim();
            
            if (input.length() == 0 || input.length() > 1) {
                System.out.println("Invalid option - please select Y or N");
            } else {
                valid = true;
            }
        
        } while(!valid);
        
        return input;
    }

    // Execute the appropriate action based on input from user
    private char doAction(char selection, Location location) {
        if (selection == 'Y') {
            this.startNewStorageContainerQuest(location);
            return 'C';
        } else if (selection == 'N') {
            String verify = this.getInputVerify();
            selection = Character.toUpperCase(verify.charAt(0));
            if (selection == 'Y') {
                return 'N';
            } else {
                return ' ';
            }
        } else {
            System.out.println("Invalid option - please select Y or N");
        }
        return ' ';
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

    private String getInputVerify() {
        
        // Declare variables for getInput method
        boolean valid = false;
        String input = null;
        Scanner keyboard = new Scanner(System.in);
        
        // Loop to gather input from user until they give valid input
        do { 
            System.out.println("Are you sure?  (Y/N)");
            
            input = keyboard.nextLine();
            input = input.trim();
            
            if (input.length() == 0 || input.length() > 1) {
                System.out.println("Invalid option - please select Y or N");
            } else {
                valid = true;
            }
        
        } while(!valid);
        
        return input;
    }
    
}
