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
public class InventoryItem implements Serializable {
    
    // class instance variables
    private String inventoryType;
    private double quantity;
    private String name;
    public enum ItemType {
        bandage,
        potion,
        weapon,
        armor,
        shield;
    }
    
    public enum bandage {
        linen ("Linen Bandage", 10),
        wool ("Wool Bandage", 20),
        silk ("Silk Bandage", 30);
        
        // Enum Variables
        private final String name;
        private final int heal;
        
        // Default Constructor
        bandage(String name, int heal) {
            this.name = name;
            this.heal = heal;
        }

        // Public getter methods
        public String getName() {
            return name;
        }

        public int getHeal() {
            return heal;
        }
        
    }
    
    public enum potion {
        lesser ("Lesser Healing Potion", 7),
        greater ("Greater Healing Potion", 14),
        major ("Major Healing Potion", 21);
        
        // Enum Variables
        private final String name;
        private final int heal;
        
        // Default Constructor
        potion(String name, int heal) {
            this.name = name;
            this.heal = heal;
        }
        
        // Public getter methods
        public String getName() {
            return name;
        }

        public int getHeal() {
            return heal;
        }
        
    }
    
    public enum weapon {
        venomSilverAxe ("Venom Silver Axe", 5),
        corruptedSkewer ("Corrupted Skewer", 10),
        nethersbane ("Nethersbane", 15);
        
        // Enum Variables
        private final String name;
        private final int damage;
        
        // Default Constructor
        weapon(String name, int damage) {
            this.name = name;
            this.damage = damage;
        }

        // Public getter methods
        public String getName() {
            return name;
        }

        public int getDamage() {
            return damage;
        }

    }
    
    public enum armor {
        holyMithrilBreastplate ("Holy Mithril Breastplate", 30),
        holyPaddedJerkin ("Holy Padded Jerkin", 20),
        birthOfTheCrown ("Birth Of The Crown", 10);
        
        // Enum Variables
        private final String name;
        private final int armor;
        
        // Default Constructor
        armor (String name, int armor) {
            this.name = name;
            this.armor = armor;
        }
        
        // Public getter methods
        public String getName() {
            return name;
        }

        public int getArmor() {
            return armor;
        }
        
    }
    
    public enum shield {
        deathsDeflection ("Death's Deflection", 30),
        oathkeepersDefender ("Oathkeeper's Defender", 20),
        championShield ("Champion Shield", 10);
        
        // Enum Variables
        private final String name;
        private final int armor;
        
        // Default Constructor
        shield (String name, int armor) {
            this.name = name;
            this.armor = armor;
        }
        
        // Public getter methods
        public String getName() {
            return name;
        }

        public int getArmor() {
            return armor;
        }
        
    }
    
    // default constructor
    public InventoryItem(String inventoryType, double quantity, String name) {
        this.inventoryType = inventoryType;
        this.quantity = quantity;
        this.name = name;
    }
    
    
    // public getter function
    public String getInventoryType() {
        return inventoryType;
    }
    
    public double getQuantity() {
        return quantity;
    }
    
    public String getName() {
        return name;
    }
    
    // public setter function
    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }
    
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    
    public void setName(String name) {
        this.name = name;
    }    

    // public hashCode function
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.inventoryType);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.quantity) ^ (Double.doubleToLongBits(this.quantity) >>> 32));
        hash = 89 * hash + Objects.hashCode(this.name);
        return hash;
    }

    // public toString function
    @Override
    public String toString() {
        return "InventoryItem{" + "inventoryType=" + inventoryType + ", quantity=" + quantity + ", name=" + name + '}';
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
        final InventoryItem other = (InventoryItem) obj;
        if (!Objects.equals(this.inventoryType, other.inventoryType)) {
            return false;
        }
        if (Double.doubleToLongBits(this.quantity) != Double.doubleToLongBits(other.quantity)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
}
