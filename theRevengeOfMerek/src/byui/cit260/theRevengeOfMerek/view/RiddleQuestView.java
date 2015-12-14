/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import byui.cit260.theRevengeOfMerek.control.RiddleQuestControl;
import byui.cit260.theRevengeOfMerek.enums.RiddleQuest;
import byui.cit260.theRevengeOfMerek.exceptions.RiddleQuestControlException;
import byui.cit260.theRevengeOfMerek.model.Location;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import therevengeofmerek.TheRevengeOfMerek;

/**
 *
 * @author co075oh
 */
public class RiddleQuestView {
    
    // Declare MENU Constant Variable
    private final String MENU = "\n"
                + "\n*********************************************************************"
                + "\n*                         Riddle Quest                              *"
                + "\n*********************************************************************"
                + "\n* I have a riddle for you to test just how wise you are.            *"
                + "\n* Are you ready?                                                    *"
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
            String input = this.getInput();
            
            // Gather the first char from the input and capitalize it
            selection = Character.toUpperCase(input.charAt(0));
            
            // Invoke the switches to execute the appropriate action
            selection = this.doAction(selection, location);
       
        } while ((selection != 'N') & (selection != 'C'));
        
        if (selection == 'C') {
            this.console.println("Quest Complete!");
        }
        
    }

    // Method to gather the input from the user 
    private String getInput() {
        
        // Declare variables for getInput method
        boolean valid = false;
        String input = null;
        
        // Loop to gather input from user until they give valid input
        do { 
            this.console.println("Do you accept the quest?  (Y/N)");
            
            try {
                input = this.keyboard.readLine();
                input = input.trim();

                if (input.length() == 0 || input.length() > 1) {
                    ErrorView.display(this.getClass().getName(), "Invalid option - please select Y or N");
                } else {
                    valid = true;
                }
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Invalid option - please select Y or N");
            }
        
        } while(!valid);
        
        return input;
    }

    // Execute the appropriate action based on input from user
    private char doAction(char selection, Location location) {
        if (selection == 'Y') {
            this.startNewRiddleQuest(location);
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
            ErrorView.display(this.getClass().getName(), "Invalid option - please select Y or N");
        }
        return ' ';
    }

    private String getInputString() {
        this.console.println("Enter a one word answer:");
        String input = null;
        
        while (input == null) {
            try {
                input = this.keyboard.readLine();
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Invalid option - please select Y or N");
            }
        }
        
        return input;
    }

    private String getInputVerify() {
        
        // Declare variables for getInput method
        boolean valid = false;
        String input = null;
        
        // Loop to gather input from user until they give valid input
        do { 
            this.console.println("Are you sure?  (Y/N)");
            
            try {
                input = this.keyboard.readLine();
                input = input.trim();

                if (input.length() == 0 || input.length() > 1) {
                    ErrorView.display(this.getClass().getName(), "Invalid option - please select Y or N");
                } else {
                    valid = true;
                }
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Please enter an answer.");
            }
        
        } while(!valid);
        
        return input;
    }

    private void startNewRiddleQuest(Location location) {
        
        // Initialize Variables
        Random rand = new Random();
        String riddle;
        String answer;
        int riddleNumber = rand.nextInt((10-1)+1)+1;
        
        // Acquire Riddle by Number
        switch (riddleNumber) {
            case 1:
                riddle = RiddleQuest.One.getRiddle();
                answer = RiddleQuest.One.getAnswer();
                break;
            case 2:
                riddle = RiddleQuest.Two.getRiddle();
                answer = RiddleQuest.Two.getAnswer();
                break;
            case 3:
                riddle = RiddleQuest.Three.getRiddle();
                answer = RiddleQuest.Three.getAnswer();
                break;
            case 4:
                riddle = RiddleQuest.Four.getRiddle();
                answer = RiddleQuest.Four.getAnswer();
                break;
            case 5:
                riddle = RiddleQuest.Five.getRiddle();
                answer = RiddleQuest.Five.getAnswer();
                break;
            case 6:
                riddle = RiddleQuest.Six.getRiddle();
                answer = RiddleQuest.Six.getAnswer();
                break;
            case 7:
                riddle = RiddleQuest.Seven.getRiddle();
                answer = RiddleQuest.Seven.getAnswer();
                break;
            case 8:
                riddle = RiddleQuest.Eight.getRiddle();
                answer = RiddleQuest.Eight.getAnswer();
                break;
            case 9:
                riddle = RiddleQuest.Nine.getRiddle();
                answer = RiddleQuest.Nine.getAnswer();
                break;
            default:
                riddle = RiddleQuest.Ten.getRiddle();
                answer = RiddleQuest.Ten.getAnswer();
                break;
        }
                
        while (!location.isQuestComplete()) {
            this.console.println(riddle);
            String playerAnswer = this.getInputString();
            boolean correct;
            try {
                correct = RiddleQuestControl.isRiddleAnswerCorrect(answer, playerAnswer);
                if (correct) {
                    location.setQuestComplete(true);
                    this.console.println("That's correct!");
                }
            } catch (RiddleQuestControlException re) {
                ErrorView.display(this.getClass().getName(), re.getMessage());
            }
            
        }
        
    }
}