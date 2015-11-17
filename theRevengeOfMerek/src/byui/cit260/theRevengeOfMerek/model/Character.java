/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author maryelsmore
 */
public enum Character implements Serializable {

    Lehi("He is the prophet and leader of the family."),
    Sariah("She is Lehi's wife and mother of the family."),
    Nephi("Faithful son and later the prophet leader of the Nephites."),
    Jacob("Nephi's faithful brother, prophet and successor to Nephi"),
    Sam("The youngest boy and faithful brother of Nephi."),
    Laman("The oldest rebellious brother and leader of the Lamanites."),
    Lemuel("The 2nd oldest rebellious brother who went with Laman"),
    Zoram("Laban's servant that became a faithful follower of Nephi");
    
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

    // public toString method for Character
    /*@Override
    public String toString() {
        return "Character{" + "name=" + name + '}';
    }*/

}