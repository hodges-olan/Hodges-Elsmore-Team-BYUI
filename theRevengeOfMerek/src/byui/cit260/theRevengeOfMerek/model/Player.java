/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.model;

import java.io.Serializable;

/**
 *
 * @author co075oh
 */
public class Player implements Serializable {
    
    // class instance variables
    private String name;
    private double health;
    private String weapon;
    private String shield;
    private String armor;
    
    public Player() {
    }
        
    // public getter function
    public String getName() {
        return name;
    }
    
    // public setter function
    public void setName(String name) {
        this.name = name;
    }
       
    // public getter function
    public double getHealth() {
        return health;
    }
    
    // public setter function
    public void setHealth(double health) {
        this.health = health;
    }
       
    // public getter function
    public String getWeapon() {
        return weapon;
    }
    
    // public setter function
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
    
    // public getter function
    public String getShield() {
        return shield;
    }
    
    // public setter function
    public void setShield(String shield) {
        this.shield = shield;
    }
    
    // public getter function
    public String getArmor() {
        return armor;
    }
    
    // public setter function
    public void setArmor(String armor) {
        this.armor = armor;
    }    
    
}
