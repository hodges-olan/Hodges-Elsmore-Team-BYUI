/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import byui.cit260.theRevengeOfMerek.control.GameControl;
import therevengeofmerek.TheRevengeOfMerek;

/**
 *
 * @author maryelsmore
 */
public class MainMenuView extends View {
    
    public MainMenuView() {
        super("\n"
            + "\n-----------------------------------"
            + "\n|           Main Menu             |"
            + "\n-----------------------------------"
            + "\n| (N)ew Game                      |"
            + "\n| (S)ave Game                     |"
            + "\n| (C)ontinue Game                 |"
            + "\n| (H)elp                          |"
            + "\n| (E)xit                          |"
            + "\n-----------------------------------");
    }
    
    // Execute the appropriate action based on input from user
    @Override
    public void doAction(Object obj) {
        char selection = (char) obj;
        
        switch(selection) {
            case 'N':
                this.startNewGame();
                break;
            case 'S':
                this.saveGame();
                break;
            case 'C':
                this.retrieveGame();
                break;
            case 'H':
                this.displayHelpMenu();
                break;
            case 'E':
                return;
            default:
                ErrorView.display(this.getClass().getName(), "Invalid Selection, Try Again");
                break;
        }
    }

    // Method to start a new game
    private void startNewGame() {
        
        // Create a new game
        GameControl.createNewGame(TheRevengeOfMerek.getPlayer());
        
        // Create and display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
        
    }

    // Method to retrieve a saved game
    private void retrieveGame() {
        
        // Create and display the save menu
        SaveMenuView saveMenu = new SaveMenuView();
        saveMenu.displayContinueProgram();
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
        
    }

    // Method to save a game
    private void saveGame() {
        
        // Create and display the save menu
        SaveMenuView saveMenu = new SaveMenuView();
        saveMenu.display();
        
    }
    
    // Method to display the help menu
    private void displayHelpMenu() {
        
        // Create and display the game menu
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
        
    }
    
}