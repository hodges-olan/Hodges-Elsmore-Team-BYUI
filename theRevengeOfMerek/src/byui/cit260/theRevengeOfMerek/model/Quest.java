/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author co075oh
 */
public class Quest implements Serializable {
    
    // class instance variables
    private String description;
    private ArrayList<InventoryItem> questRewards;
    
    // default constructor
    public Quest(String description, ArrayList<InventoryItem> questRewards) {
        this.description = description;
        this.questRewards = questRewards;
    }
    
    // public getter function
    public String getDescription() {
        return description;
    }

    public ArrayList<InventoryItem> getQuestRewards() {
        return questRewards;
    }
    
    // public setter function
    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuestRewards(ArrayList<InventoryItem> questRewards) {
        this.questRewards = questRewards;
    }

    // public hashCode function
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + Objects.hashCode(this.questRewards);
        return hash;
    }

    // public toString function
    @Override
    public String toString() {
        return "Quest{" + "description=" + description + ", questRewards=" + questRewards + '}';
    }

    // public equals function
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Quest other = (Quest) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.questRewards, other.questRewards)) {
            return false;
        }
        return true;
    }
    
    
    
}