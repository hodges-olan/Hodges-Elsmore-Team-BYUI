/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.enums;

import byui.cit260.theRevengeOfMerek.model.Location;
import java.io.Serializable;

/**
 *
 * @author maryelsmore
 */
public enum Character implements Serializable {

    Peter("A blacksmith by trade and a honorable man of the people."),
    Isaac("The town trickster, but helpful to all those in need."),
    Oscar("The local doctor for the townsfolk."),
    Aiden("A carpenter by trade, and a family man."),
    Christopher("Owner of a local bank."),
    Urijah("An appretice to the local cobbler."),
    Landyn("A journeyman mason."),
    Tristen("The local butcher and deacon in the church."),
    Giovani("A glazier by trade and a family man at heart."),
    Darian("An apprencite porter by trade."),
    Kai("The local master mason who has multiple apprentices locally."),
    Connor("A carpenter by trade, and a family man."),
    David("An appretice to the local cobbler."),
    Anthony("A blacksmith by trade and a honorable man of the people."),
    Bailey("A journeyman mason."),
    Tristan("Owner of a local bank."),
    Jamison("The local master cobbler."),
    Daxton("An apprentice blacksmith who hopes one day to be a master blacksmith."),
    Neymar("The local doctor for the townsfolk."),
    Allen("A fletcher by trade."),
    Jacob("A local minstrel ready to entertain at local parties."),
    Robert("A journeyman mason."),
    Dominic("A steward for one of the local nobles."),
    Jackson("A glazier by trade and a family man at heart."),
    Josh("The town trickster, but helpful to all those in need.");
    
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