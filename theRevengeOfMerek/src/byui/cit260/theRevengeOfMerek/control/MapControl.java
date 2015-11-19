/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.control;

import byui.cit260.theRevengeOfMerek.model.Location;
import byui.cit260.theRevengeOfMerek.model.Map;

/**
 *
 * @author co075oh
 */
public class MapControl {

    static Map createMap() {
        
        // Create the map
        Map map = new Map(5, 5);
        
        // Assign the different quests to locations in the map
        assignQuestsToLocations(map);
        
        return map;
        
    }

    static void moveActorsToStartingLocation(Map map) {
        System.out.println("*** called moveActorsToStartingLocation() in MapControl ***");
    }

    private static void assignQuestsToLocations(Map map) {
        
        // Get the 2D array for the map
        Location[][] locations = map.getLocations();
        
        // Assign Quests to each location
        locations[0][0].setQuestType("shipment");
        locations[0][1].setQuestType("strength");
        locations[0][2].setQuestType("artifact");
        locations[0][3].setQuestType("strength");
        locations[0][4].setQuestType("strength");
        locations[1][0].setQuestType("artifact");
        locations[1][1].setQuestType("container");
        locations[1][2].setQuestType("container");
        locations[1][3].setQuestType("riddle");
        locations[1][4].setQuestType("artifact");
        locations[2][0].setQuestType("riddle");
        locations[2][1].setQuestType("strength");
        locations[2][2].setQuestType("shipment");
        locations[2][3].setQuestType("artifact");
        locations[2][4].setQuestType("container");
        locations[3][0].setQuestType("artifact");
        locations[3][1].setQuestType("container");
        locations[3][2].setQuestType("riddle");
        locations[3][3].setQuestType("container");
        locations[3][4].setQuestType("riddle");
        locations[4][0].setQuestType("riddle");
        locations[4][1].setQuestType("shipment");        
        locations[4][2].setQuestType("strength");
        locations[4][3].setQuestType("shipment");
        locations[4][4].setQuestType("shipment");
        
    }

}
