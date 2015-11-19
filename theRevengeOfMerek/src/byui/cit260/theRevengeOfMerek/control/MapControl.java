/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.control;

import byui.cit260.theRevengeOfMerek.model.Map;

/**
 *
 * @author co075oh
 */
public class MapControl {

    static Map createMap() {
        
        // Create the map
        Map map = new Map(5, 5);
        
        return map;
        
    }

    static void moveActorsToStartingLocation(Map map) {
        System.out.println("*** called moveActorsToStartingLocation() in MapControl ***");
    }

}
