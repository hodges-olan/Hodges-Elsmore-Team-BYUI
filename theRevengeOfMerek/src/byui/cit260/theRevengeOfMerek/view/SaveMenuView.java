/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import byui.cit260.theRevengeOfMerek.control.GameControl;
import java.io.IOException;
import therevengeofmerek.TheRevengeOfMerek;

/**
 *From the Game Play Menu, the user will select the Save option.  This will bring up this menu, which will 

ask them if they wish to save their current progress. 

 If yes, the player is prompted to enter the location of the file where they want to save the game. Then it 

will save their progress and return them back to the Game Play Menu.  If an invalid file location is 

entered an error message is displayed and the player is prompted to enter a valid file name again. 

If no, it will not save their progress and return them back to the Game Play Menu.
 * @author maryelsmore
 */
public class SaveMenuView extends View {
    
    // Declare MENU Constant Variable
    public SaveMenuView() {
        super("\n"
        + "\n------------------------------------"
        + "\n|Do you wish to save your progress?|"
        + "\n|----------------------------------|"
        + "\n| (Y)es                            |"
        + "\n| (E)xit                           |"
        + "\n------------------------------------");
    }

    // Execute the appropriate action based on input from user
    @Override
    public void doAction(Object obj) {
        char selection = (char) obj;
        
        switch(selection) {
            case 'Y':
                this.displaySaveProgram();
                break;
            case 'E':
                return;
            default:
                this.console.println("\n Invalid Selection, Try Again");
                break;
        }
    }

    private void displaySaveProgram() {
        // Display where to Save Game
        this.console.println("\n"
                + "\n------------------------------------"
                + "\n|            Save Game             |"
                + "\n|----------------------------------|"
                + "\n| Please enter the location you    |"
                + "\n| would like to save your game:    |"
                + "\n|                                  |"
                + "\n------------------------------------"
                + "\n\nPress any key to return to the Save Menu");
        
        // Wait for the user to press any key
        String input = null;
        try {
            input = this.keyboard.readLine();
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), "\nInvalid selection, please try again.");
        }
        
        // Save the game to the specified file
        try {
            GameControl.saveGame(TheRevengeOfMerek.getCurrentGame(), input);
        } catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        
    }
    
    public void displayContinueProgram() {
        
        // Display where to Save Game
        this.console.println("\n"
                + "\n------------------------------------"
                + "\n|         Continue Game            |"
                + "\n|----------------------------------|"
                + "\n| Please enter the location of the |"
                + "\n| game you would like to continue: |"
                + "\n|                                  |"
                + "\n------------------------------------");
        
        // Wait for the user to press any key
        String input = null;
        try {
            input = this.keyboard.readLine();
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), "\nInvalid selection, please try again.");
        }
        
        // Save the game to the specified file
        try {
            GameControl.continueGame(input);
        } catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        
    }

}