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
    public boolean calculateVolume(double radius, double height, double reqVolume) {
        double volume;
        
        if (height <= 0 || radius <= 0) {
            return false;
        }
        
        volume = Math.PI * Math.pow(radius, 2) * height;
        if (Math.floor(volume) == reqVolume) {
            return true;
        }
        
        return false;
    }
}
