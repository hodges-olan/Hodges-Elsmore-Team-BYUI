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
public class ArtifactStrengthQuest implements Serializable {
    
    // class instance variables
    private String description;
    private double opponentHealth;
    private double opponentArmor;
    private double opponentStrength;
    private double WeaponDamage;

    // default constructor
    public ArtifactStrengthQuest() {
    }

    // public getter function
    public String getDescription() {
        return description;
    }

    // public setter function
    public void setDescription(String description) {
        this.description = description;
    }

    // public getter function
    public double getOpponentHealth() {
        return opponentHealth;
    }

    // public setter function
    public void setOpponentHealth(double opponentHealth) {
        this.opponentHealth = opponentHealth;
    }

    // public getter function
    public double getOpponentArmor() {
        return opponentArmor;
    }

    // public setter function
    public void setOpponentArmor(double opponentArmor) {
        this.opponentArmor = opponentArmor;
    }

    // public getter function
    public double getOpponentStrength() {
        return opponentStrength;
    }

    // public setter function
    public void setOpponentStrength(double opponentStrength) {
        this.opponentStrength = opponentStrength;
    }

    // public getter function
    public double getWeaponDamage() {
        return WeaponDamage;
    }

    // public setter function
    public void setWeaponDamage(double WeaponDamage) {
        this.WeaponDamage = WeaponDamage;
    }

    // public hashCode function
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.description);
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.opponentHealth) ^ (Double.doubleToLongBits(this.opponentHealth) >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.opponentArmor) ^ (Double.doubleToLongBits(this.opponentArmor) >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.opponentStrength) ^ (Double.doubleToLongBits(this.opponentStrength) >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.WeaponDamage) ^ (Double.doubleToLongBits(this.WeaponDamage) >>> 32));
        return hash;
    }

    // public toString function
    @Override
    public String toString() {
        return "ArtifactStrengthQuest{" + "description=" + description + ", opponentHealth=" + opponentHealth + ", opponentArmor=" + opponentArmor + ", opponentStrength=" + opponentStrength + ", WeaponDamage=" + WeaponDamage + '}';
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
        final ArtifactStrengthQuest other = (ArtifactStrengthQuest) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (Double.doubleToLongBits(this.opponentHealth) != Double.doubleToLongBits(other.opponentHealth)) {
            return false;
        }
        if (Double.doubleToLongBits(this.opponentArmor) != Double.doubleToLongBits(other.opponentArmor)) {
            return false;
        }
        if (Double.doubleToLongBits(this.opponentStrength) != Double.doubleToLongBits(other.opponentStrength)) {
            return false;
        }
        if (Double.doubleToLongBits(this.WeaponDamage) != Double.doubleToLongBits(other.WeaponDamage)) {
            return false;
        }
        return true;
    }
        
}
