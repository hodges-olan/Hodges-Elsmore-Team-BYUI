/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import byui.cit260.theRevengeOfMerek.control.StorageContainerQuestControl;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author co075oh
 */
public class StorageContainerQuestView {

    // Method to display the welcome banner
    void displayBanner() {
        
        System.out.println("\n"
                + "\n*********************************************************************"
                + "\n*                    Storage Container Quest                        *"
                + "\n*********************************************************************"
                + "\n* We are so glad that you have come!  We have a shipment which      *"
                + "\n* we need to put into a container for safe keeping during it's      *"
                + "\n* journey.  Could you please help us?                               *"
                + "\n*********************************************************************");
        
        // Declare variables
        char selection = ' ';
        
        // Loop to show and gather input from user in main menu
        do {            
            // Gather input from the player
            String input = this.getInput();
            
            // Gather the first char from the input and capitalize it
            selection = Character.toUpperCase(input.charAt(0));
            
            // Invoke the switches to execute the appropriate action
            selection = this.doAction(selection);
       
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
    private char doAction(char selection) {
        if (selection == 'Y') {
            this.startNewStorageContainerQuest();
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

    private void startNewStorageContainerQuest() {
        
        // Initialize random volume requirement between 400 and 10
        Random rand = new Random();
        double reqVolume = rand.nextInt((400-10)+1)+10;
        boolean questAccomplished = false;
        
        while (!questAccomplished) {
            System.out.println("We need a container that will fit " + reqVolume + " square feet of water.");
            double radius = this.getInputDouble("radius");
            double height = this.getInputDouble("height");
            StorageContainerQuestControl instance = new StorageContainerQuestControl();
            boolean result = instance.calculateVolume(radius, height, reqVolume);
            if (!result) {
                System.out.println("I'm sorry but that container is the wrong size.  Please try again.");
            } else {
                System.out.println("That will fit the requirements exactly!  Thank you!");
                questAccomplished = true;
            }
        }
        
    }

    private double getInputDouble(String dimension) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the " + dimension + " we should use?");
        boolean valid = false;
        
        while (!input.hasNextDouble()) {
            System.out.println("You must enter a valid number.  Try again.");
            input.next();
        }
        double value = input.nextDouble();
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
