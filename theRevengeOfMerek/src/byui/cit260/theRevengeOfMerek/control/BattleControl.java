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
public class BattleControl {
    
    // Public method to reduce the health of a player with a Damage over Time (DOT)
    public double[] reduceHealthDOT(double weapon, double strength, double armor) {
        
        // Declare variables
        double damage;
        double dot;
        
        // Validation Checks
        if(weapon <= 0 || strength <= 0 || armor <= 0) {
            return new double[]{-1.0, -1.0};
        }
        
        // Calculate damage
        damage = (weapon * strength) - armor;
        
        // Calculate Damage over Time (DOT)
        dot = damage * 0.3;
        
        // Calculate initial inflicted damage
        damage = damage * 0.8;
        
        // Return values
        return new double[]{Math.round(damage), Math.round(dot)};
    }
    
    // Public method to reduce health from a normal attack
    public double reduceHealthNormal(double weapon, double strength, double armor) {
        
        // Declare variables
        double damage;
        
        // Validation Checks
        if(weapon <= 0 || strength <= 0 || armor <= 0) {
            return -1.0;
        }
        
        // Calculate damage
        damage = (weapon * strength) - armor;
        
        // Return values
        return Math.round(damage);
    }
}
