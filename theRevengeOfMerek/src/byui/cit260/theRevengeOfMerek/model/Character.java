/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.model;

import java.io.Serializable;

/**
 *
 * @author maryelsmore
 */
public enum Character implements Serializable {

    Peter(""),
    Isaac(""),
    Oscar(""),
    Aiden(""),
    Christopher(""),
    Urijah(""),
    Landyn(""),
    Tristen(""),
    Giovani(""),
    Darian(""),
    Kai(""),
    Connor(""),
    David(""),
    Anthony(""),
    Bailey(""),
    Tristan(""),
    Jamison(""),
    Daxton(""),
    Neymar(""),
    Allen(""),
    Jacob(""),
    Robert(""),
    Dominic(""),
    Jackson(""),
    Josh("");
    
    private final String description;
    private final Location location;

    // default constructor class
    Character(String description) {
        this.description = description;
        location = new Location();
    }

    public String getDescription() {
        return description;
    }

    public Location getLocation() {
        return location; 
    }

}