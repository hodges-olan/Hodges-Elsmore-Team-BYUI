/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.control;

/**
 *
 * @author co075oh
 */
public class StorageContainerQuestControl {
    
    // public calculateVolume method for the Storage Container Quest
    public boolean calculateVolume(double radius, double height, double reqVolume) {
        
        // Define variables
        double volume;
        
        // Error checking
        if (height <= 0 || radius <= 0) {
            return false;
        }
        
        // Perform calculation of volume of a cylinder
        volume = Math.PI * Math.pow(radius, 2) * height;
        
        // Validate volume matches the requirement
        if (Math.floor(volume) == reqVolume) {
            return true;
        }
        
        // Else return false
        return false;
    }
}
