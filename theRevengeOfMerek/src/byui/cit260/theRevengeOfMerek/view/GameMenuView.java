/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import byui.cit260.theRevengeOfMerek.control.GameControl;
import byui.cit260.theRevengeOfMerek.control.MapControl;
import byui.cit260.theRevengeOfMerek.exceptions.MapControlException;
import byui.cit260.theRevengeOfMerek.model.Game;
import byui.cit260.theRevengeOfMerek.model.InventoryItem;
import byui.cit260.theRevengeOfMerek.model.Location;
import byui.cit260.theRevengeOfMerek.model.Map;
import byui.cit260.theRevengeOfMerek.model.StorageContainerQuest;
import java.util.ArrayList;
import java.util.Scanner;
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
            + "\n| (D)isplay Map                   |"
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
            case 'D':
                this.displayMap();
                break;
            case 'I':
                this.displayInventory();
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
    private void displayInventory() {
        
        // Create and display the inventory menu
        InventoryMenuView inventoryMenu = new InventoryMenuView();
        inventoryMenu.display();
        
    }
    
    //Display Game Quests
    private void displayQuests() {
        
        //Create and display the save menu
        QuestProgressView questMenu = new QuestProgressView();
        questMenu.display();
        
    }

    // Method to move Player
    private void movePlayer() {
        
        // Get the current game, map, and locations
        Game game = TheRevengeOfMerek.getCurrentGame();
        Map map = game.getMap();
        Location[][] locations = map.getLocations();
        
        // Display Map
        this.displayMap();
        
        // Request new location to move to
        boolean valid = false;
        int locationx;
        int locationy;
        Scanner keyboard = new Scanner(System.in);
        
        // Gather new X coordinate
        System.out.println("Enter new X coordinate");
        locationx = this.getInputInteger();       
        
        // Gather new X coordinate
        System.out.println("Enter new Y coordinate");
        locationy = this.getInputInteger();
        
        // Decrement values for 2D array
        locationy = --locationy;
        locationx = --locationx;
        try {
            // Call movePlayerToLocation function
            MapControl.movePlayerToLocation(map, locations, locationy, locationx);
            
            // If Quest not complete, Start it
            if (!locations[locationy][locationx].isQuestComplete()) {
                String questType = locations[locationy][locationx].getQuestType();
                switch(questType) {
                    case "artifact":
                        System.out.println("*** call artifact quest ***");
                        break;
                    case "container":
                        StorageContainerQuestView storageContainerQuestView = new StorageContainerQuestView();
                        storageContainerQuestView.displayMenu(locations[locationy][locationx]);
                        break;
                    case "riddle":
                        RiddleQuestView riddleQuestView = new RiddleQuestView();
                        riddleQuestView.displayMenu(locations[locationy][locationx]);
                        break;
                    case "shipment":
                        System.out.println("*** call shipment quest ***");
                        break;
                    case "strength":
                        System.out.println("*** call strength quest ***");
                        return;
                    default:
                        System.out.println("\n Invalid Selection, Try Again");
                        break;
                }

            }
        } catch (MapControlException me) {
            System.out.println(me.getMessage());
        }
        
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

    private void displayMap() {
        
        // Get the current game map (including dimensions) and locations
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
                if (locations[i][j].isPlayerPresent()) {
                    System.out.print(" X |");
                } else if (locations[i][j].isQuestComplete()) {
                    System.out.print(" C |");
                } else {
                    System.out.print(" O |");
                }
            }
            System.out.println("\n-----------------------");
        }
    }
    
    private Integer getInputInteger() {
        Integer value = null;
        Scanner keyboard = new Scanner(System.in);
        String input;
        
        while (value == null) {
            try {
                // parse and convert number from text to integer
                input = keyboard.nextLine();
                value = Integer.parseInt(input);
            } catch (NumberFormatException nf) {
                System.out.println("\nYou must enter a valid number. Please try again.");
            }
        }
            
        return value;
    }
       
}
