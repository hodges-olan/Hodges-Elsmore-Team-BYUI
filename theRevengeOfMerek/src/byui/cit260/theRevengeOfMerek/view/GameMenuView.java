/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import byui.cit260.theRevengeOfMerek.control.GameControl;
import byui.cit260.theRevengeOfMerek.model.Game;
import byui.cit260.theRevengeOfMerek.model.InventoryItem;
import byui.cit260.theRevengeOfMerek.model.Location;
import byui.cit260.theRevengeOfMerek.model.Map;
import java.util.ArrayList;
import therevengeofmerek.TheRevengeOfMerek;

/**
 *
 * @author maryelsmore
 */
public class GameMenuView extends View {

    // Declare MENU Constant Variable
    public GameMenuView() {
        super("\n"
            + "\n-----------------------------------"
            + "\n|           Game Menu             |"
            + "\n-----------------------------------"
            + "\n| (I)nventory                     |"
            + "\n| (Q)uests                        |"
            + "\n| (M)ove                          |"
            + "\n| (S)ave                          |"
            + "\n| (H)elp                          |"
            + "\n| (E)xit                          |"
            + "\n-----------------------------------");
    } 
    
    // Execute the appropriate action based on input from user
    @Override
    public void doAction(Object obj) {
        char selection = (char) obj;
        
        switch(selection) {
            case 'I':
                this.displayinventory();
                break;
            case 'Q':
                this.displayQuests();
                break;
            case 'M':
                this.movePlayer();
                break;
            case 'S':
                this.saveGame();
                break;
            case 'H':
                this.displayHelpMenu();
                break;
            case 'E':
                return;
            default:
                System.out.println("\n Invalid Selection, Try Again");
                break;
        }
    }

    // Display the players inventory    
    private void displayinventory() {
        
        // Get the sorted list of inventory items for the current game
        ArrayList<InventoryItem> inventory = GameControl.getSortedInventoryList();
        
        // Display the sorted inventory list
        System.out.println("\nList of Inventory Items");
        System.out.println("Name" + "\t" +
                "Type" + "\t" +
                "Quantity");
        for (InventoryItem inventoryItem: inventory) {
            System.out.println(inventoryItem.getName() + "\t" +
                    inventoryItem.getInventoryType() + "\t" +
                    inventoryItem.getQuantity());
        }
        
    }
    
    //Display Game Quests
    private void displayQuests() {
        
        //Create and display the save menu
        QuestProgressView questMenu = new QuestProgressView();
        questMenu.display();
        
    }

    // Method to move Player
    private void movePlayer() {
        
        // Get the current game, map (including rows and columns), and locations
        Game game = TheRevengeOfMerek.getCurrentGame();
        Map map = game.getMap();
        int rows = map.getRowCount();
        int columns = map.getColumnCount();
        Location[][] locations = map.getLocations();
        
        // Display title
        System.out.println("\n\n  The Revenge of Merek");
        
        // Display map
        System.out.println("    1   2   3   4   5");
        System.out.println("-----------------------");
        for (int i=0; i < rows; i++) {
            System.out.print((i+1) + " |");
            for (int j=0; j < columns; j++) {
                if (locations[i][j].isQuestComplete()) {
                    System.out.print(" C |");
                } else {
                    System.out.print(" O |");
                }
            }
            System.out.println("\n-----------------------");
        }
        
        // Request new location to move to
        
        // Call movePlayerToLocation function
        
    }

    // Method to save a game
    private void saveGame() {
        
        //Create and display the save menu
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
