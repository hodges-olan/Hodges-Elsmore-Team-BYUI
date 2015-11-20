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
            + "\n| (A)ctive Quests                 |"
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
            case 'A':
                this.displayActiveQuests();
                break;
            case 'C':
                this.displayCompletedQuests();
                break;
            case 'O':
                this.displayOutstandingQuests();
                break;
            case 'E':
                return;
            default:
                System.out.println("\n Invalid Selection, Try Again");
                break;
        }
    }

    private void displayActiveQuests() {
        System.out.println("displayActiveQuests method called!");
    }

    private void displayCompletedQuests() {
        
        // Get the current game, map (including rows and columns), and locations
        Game game = TheRevengeOfMerek.getCurrentGame();
        Map map = game.getMap();
        Location[][] locations = map.getLocations();
        
        // Display completed quests and gather total
        System.out.println("Completed Quests");
        System.out.println("----------------");
        int total = 0;
        for (Location[] row : locations) {
            for (Location location : row) {
                if (location.isQuestComplete()) {
                    total++;
                    System.out.println("Quest at " + location.getRow() + "," + location.getColumn());
                }
            }
        }
        System.out.println("----------------");
        System.out.println("Total Completed: " + total);
        
    }

    private void displayOutstandingQuests() {
        System.out.println("displayOutstandingQuests method called!");
    }
}
