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
    public double[] reduceHealthDOT(double weapon, double strength, double armor) {
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
        return new double[]{damage, dot};
    }
    
    public double reduceHealthNormal(double weapon, double strength, double armor) {
        double damage;
        
        // Validation Checks
        if(weapon <= 0 || strength <= 0 || armor <= 0) {
            return -1.0;
        }
        
        // Calculate damage
        damage = (weapon * strength) - armor;
        
        // Return values
        return damage;
    }
}
