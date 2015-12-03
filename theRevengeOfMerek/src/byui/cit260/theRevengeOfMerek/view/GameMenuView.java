/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import byui.cit260.theRevengeOfMerek.control.MapControl;
import byui.cit260.theRevengeOfMerek.exceptions.MapControlException;
import byui.cit260.theRevengeOfMerek.model.Game;
import byui.cit260.theRevengeOfMerek.model.Location;
import byui.cit260.theRevengeOfMerek.model.Map;
import java.io.IOException;
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
    
    // Method to display the main menu
    @Override
    public void display() {
        
        // Declare variables
        char selection = ' ';
        
        // Loop to show and gather input from user in main menu
        do {
            // Print the main menu
            this.console.println(this.promptMessage);
            
            // Gather input from the player
            String value = this.getInput();
            
            // Gather the first char from the input and capitalize it
            try {
                selection = Character.toUpperCase(value.charAt(0));
            } catch (IndexOutOfBoundsException ioo) {
                ErrorView.display(this.getClass().getName(), "Invalid option - please select from the menu above");
            }
            
            // Invoke the switches to execute the appropriate action
            this.doAction(selection);
            
            if (this.checkGameComplete()) {
                this.closingSequence();
                selection = 'E';
            }
       
        } while (selection != 'E');
        
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
                ErrorView.display(this.getClass().getName(), "Invalid Selection, Try Again");
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
        int locationx;
        int locationy;
        
        // Gather new X coordinate
        this.console.println("Enter new X coordinate");
        locationx = this.getInputInteger();       
        
        // Gather new X coordinate
        this.console.println("Enter new Y coordinate");
        locationy = this.getInputInteger();
        
        // Decrement values for 2D array
        locationy = --locationy;
        locationx = --locationx;
        try {
            // Call movePlayerToLocation function
            MapControl.movePlayerToLocation(map, locations, locationy, locationx);
            
            // Shipment Quest Check
            ShipmentQuestView shipmentQuestView = new ShipmentQuestView();
            shipmentQuestView.QuestComplete(locations[locationy][locationx]);
            
            // If Quest not complete, Start it
            if (!locations[locationy][locationx].isQuestComplete()) {
                String questType = locations[locationy][locationx].getQuestType();
                switch(questType) {
                    case "artifact":
                        ArtifactQuestView artifactQuestView = new ArtifactQuestView();
                        artifactQuestView.displayMenu(locations[locationy][locationx]);
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
                        shipmentQuestView.displayMenu(locations[locationy][locationx]);
                        break;
                    case "strength":
                        StrengthQuestView strengthQuestView = new StrengthQuestView();
                        strengthQuestView.displaymenu(locations[locationy][locationx]);
                        return;
                    default:
                        ErrorView.display(this.getClass().getName(), "Invalid Selection, Try Again");
                        break;
                }

            }
        } catch (MapControlException me) {
            ErrorView.display(this.getClass().getName(), me.getMessage());
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
        this.console.println("\n\n  The Revenge of Merek");
        
        // Display map
        this.console.println("    1   2   3   4   5");
        this.console.println("  ---------------------");
        for (int i=0; i < rows; i++) {
            this.console.print((i+1) + " |");
            for (int j=0; j < columns; j++) {
                if (locations[i][j].isPlayerPresent()) {
                    this.console.print(" X |");
                } else if (locations[i][j].isQuestComplete()) {
                    this.console.print(" C |");
                } else {
                    this.console.print(" O |");
                }
            }
            this.console.println("\n  ---------------------");
        }
    }
    
    private Integer getInputInteger() {
        Integer value = null;
        String input = null;
        
        while (value == null) {
            try {
                try {
                    // parse and convert number from text to integer
                    input = this.keyboard.readLine();
                } catch (IOException ex) {
                    ErrorView.display(this.getClass().getName(), "You must enter a valid number. Please try again.");
                }
                value = Integer.parseInt(input);
            } catch (NumberFormatException nf) {
                ErrorView.display(this.getClass().getName(), "You must enter a valid number. Please try again.");
            }
        }
            
        return value;
    }

    private boolean checkGameComplete() {
        
        // Declare variables
        boolean complete = true;
        Game game = TheRevengeOfMerek.getCurrentGame();
        Map map = game.getMap();
        Location[][] locations = map.getLocations();
        
        // Check to see if all locations have completed their quests
        for (Location[] columns : locations) {
            for (Location location : columns) {
                if (!location.isQuestComplete()) {
                    complete = false;
                }
            }
        }
        
        // Return result
        return complete;
        
    }

    private void closingSequence() {
        
        // Display the closing sequence
        this.console.println("\n"
                + "\n*********************************************************************"
                + "\n*                      The Revenge of Merek                         *"
                + "\n*********************************************************************"
                + "\n* You and all of the Lord's in the realm have banned together and   *"
                + "\n* overthrown Worthag!  You have re-established Merek as king and    *"
                + "\n* all of the people are rejoicing!                                  *"
                + "\n*                                                                   *"
                + "\n*                      You have won the game!                       *"
                + "\n*                                                                   *"
                + "\n*********************************************************************"
                + "\n\nPress any key to continue");
        
        // Wait for the user to press any key
        String input = null;
        try {
            input = this.keyboard.readLine();
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), "You must enter a valid selection. Please try again.");
        }
        
    }
       
}
