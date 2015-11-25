/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.enums;

/**
 *
 * @author maryelsmore
 */
public enum Character {

    Peter("A blacksmith by trade and a honorable man of the people.", 0, 0),
    Isaac("The town trickster, but helpful to all those in need.", 0, 1),
    Oscar("The local doctor for the townsfolk.", 0, 2),
    Aiden("A carpenter by trade, and a family man.", 0, 3),
    Christopher("Owner of a local bank.", 0, 4),
    Urijah("An appretice to the local cobbler.", 1, 0),
    Landyn("A journeyman mason.", 1, 1),
    Tristen("The local butcher and deacon in the church.", 1, 2),
    Giovani("A glazier by trade and a family man at heart.", 1, 3),
    Darian("An apprencite porter by trade.", 1, 4),
    Kai("The local master mason who has multiple apprentices locally.", 2, 0),
    Connor("A carpenter by trade, and a family man.", 2, 1),
    David("An appretice to the local cobbler.", 2, 2),
    Anthony("A blacksmith by trade and a honorable man of the people.", 2, 3),
    Bailey("A journeyman mason.", 2, 4),
    Tristan("Owner of a local bank.", 3, 0),
    Jamison("The local master cobbler.", 3, 1),
    Daxton("An apprentice blacksmith who hopes one day to be a master blacksmith.", 3, 2),
    Neymar("The local doctor for the townsfolk.", 3, 3),
    Allen("A fletcher by trade.", 3, 4),
    Jacob("A local minstrel ready to entertain at local parties.", 4, 0),
    Robert("A journeyman mason.", 4, 1),
    Dominic("A steward for one of the local nobles.", 4, 2),
    Jackson("A glazier by trade and a family man at heart.", 4, 3),
    Josh("The town trickster, but helpful to all those in need.", 4, 4);
    
    // Class Instance Variables
    private final String description;
    private final int locationx;
    private final int locationy;

    // default constructor method
    Character(String description, int locationx, int locationy) {
        this.description = description;
        this.locationx = locationx;
        this.locationy = locationy;
    }

    // Public getter functions
    public String getDescription() {
        return description;
    }

    public int getLocationX() {
        return locationx; 
    }
    
    public int getLocationY() {
        return locationy; 
    }

}