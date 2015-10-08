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

    // public hashCode function
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.health) ^ (Double.doubleToLongBits(this.health) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.weapon);
        hash = 17 * hash + Objects.hashCode(this.shield);
        hash = 17 * hash + Objects.hashCode(this.armor);
        return hash;
    }

    // public toString function
    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", health=" + health + ", weapon=" + weapon + ", shield=" + shield + ", armor=" + armor + '}';
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
        final Player other = (Player) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (Double.doubleToLongBits(this.health) != Double.doubleToLongBits(other.health)) {
            return false;
        }
        if (!Objects.equals(this.weapon, other.weapon)) {
            return false;
        }
        if (!Objects.equals(this.shield, other.shield)) {
            return false;
        }
        if (!Objects.equals(this.armor, other.armor)) {
            return false;
        }
        return true;
    }
    
}
