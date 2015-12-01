/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import byui.cit260.theRevengeOfMerek.model.Game;
import byui.cit260.theRevengeOfMerek.model.Location;
import byui.cit260.theRevengeOfMerek.model.Map;
import therevengeofmerek.TheRevengeOfMerek;

/**
 *
 * @author co075oh
 */
public class QuestProgressView extends View {
    
// Declare MENU Constant Variable
    public QuestProgressView() {
        super("\n"
            + "\n-----------------------------------"
            + "\n|       Quest Progress Menu       |"
            + "\n-----------------------------------"
            + "\n| (C)ompleted Quests              |"
            + "\n| (O)utstanding Quests            |"
            + "\n| (E)xit                          |"
            + "\n-----------------------------------");
    }

    // Execute the appropriate action based on input from user
    @Override
    public void doAction(Object obj) {
        char selection = (char) obj;
        
        switch(selection) {
            case 'C':
                this.displayCompletedQuests();
                break;
            case 'O':
                this.displayOutstandingQuests();
                break;
            case 'E':
                return;
            default:
                this.console.println("\n Invalid Selection, Try Again");
                break;
        }
    }

    private void displayCompletedQuests() {
        
        // Get the current game, map (including rows and columns), and locations
        Game game = TheRevengeOfMerek.getCurrentGame();
        Map map = game.getMap();
        Location[][] locations = map.getLocations();
        
        // Display completed quests and gather total
        this.console.println("Completed Quests");
        this.console.println("----------------");
        int total = 0;
        int complete = 0;
        int currentRow;
        int currentColumn;
        for (Location[] row : locations) {
            for (Location location : row) {
                total++;
                if (location.isQuestComplete()) {
                    complete++;
                    currentRow = (int) location.getRow();
                    currentColumn = (int) location.getColumn();
                    currentRow = ++currentRow;
                    currentColumn = ++currentColumn;
                    this.console.println("Quest at " + currentRow + "," + currentColumn);
                }
            }
        }
        this.console.println("----------------");
        if ((complete < 0) || (total < 0) || (total < complete)) {
            this.console.println("ERROR IN CALCULATING TOTALS");
        } else {
            double percentage = 100 * complete/total;
            this.console.println("Total Completed: " + complete);
            this.console.println("Percent Complete: " + percentage);
        }
        
    }

       private void displayOutstandingQuests() {
        // Get the current game, map (including rows and columns), and locations
        Game game = TheRevengeOfMerek.getCurrentGame();
        Map map = game.getMap();
        Location[][] locations = map.getLocations();
        
        // Display outstanding quests and gather total
        this.console.println("Outstanding Quests");
        this.console.println("----------------");
        int total = 0;
        int outstanding = 0;
        int currentRow;
        int currentColumn;
        for (Location[] row : locations) {
            for (Location location : row) {
                total++;
                if (!location.isQuestComplete()) {
                    outstanding++;
                    currentRow = (int) location.getRow();
                    currentColumn = (int) location.getColumn();
                    currentRow = ++currentRow;
                    currentColumn = ++currentColumn;
                    this.console.println("Quest at " + currentRow + "," + currentColumn);
                }
            }
        }
        this.console.println("----------------");
        if ((outstanding < 0) || (total < 0) || (total < outstanding)) {
            this.console.println("ERROR IN CALCULATING TOTALS");
        } else {
            double percentage = 100 * outstanding/total;
            this.console.println("Total Outstanding: " + outstanding);
            this.console.println("Percent Outstanding: " + percentage);
        }
        
    }
       
}
    

