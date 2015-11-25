/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.control;

import byui.cit260.theRevengeOfMerek.exceptions.StorageContainerQuestControlException;

/**
 *
 * @author co075oh
 */
public class StorageContainerQuestControl {
    
    // public calculateVolume method for the Storage Container Quest
    public void calculateVolume(double radius, double height, double reqVolume) throws StorageContainerQuestControlException {
        
        // Define variables
        double volume;
        
        // Error checking
        if (height <= 0 || radius <= 0) {
            throw new StorageContainerQuestControlException ("Please enter a value greater than 0");
        }
        
        // Perform calculation of volume of a cylinder
        volume = Math.PI * Math.pow(radius, 2) * height;
        
        // Validate volume matches the requirement
        if (Math.floor(volume) != reqVolume) {
            throw new StorageContainerQuestControlException ("I'm sorry but that container is the wrong size.  Please try again.");
        }
        
    }
}
