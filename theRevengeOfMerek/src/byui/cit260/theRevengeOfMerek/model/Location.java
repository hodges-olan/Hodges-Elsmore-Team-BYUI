/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.model;

import byui.cit260.theRevengeOfMerek.enums.Character;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author co075oh
 */
public class Location implements Serializable {
    
    // class instance variables
    private double row;
    private double column;
    private boolean questComplete;
    private boolean playerPresent;
    private Character character;
    private String questType;
    private ArtifactStrengthQuest artifactQuest;
    private ArtifactStrengthQuest strengthQuest;
    private RiddleQuest riddleQuest;
    private ShipmentQuest shipmentQuest;
    private StorageContainerQuest storageContainerQuest;

    private enum towns {
        Ballinamallard,
        Armagh,
        Aelinmiley,
        Marnmouth,
        Martslock,
        Islesbury,
        Glaenarm,
        Alnwick,
        Mountmend,
        Blencalgo,
        Warlington,
        Chepstow,
        Bournemouth,
        Blencogo,
        Wigston,
        Iyesgarth,
        Murtovaara,
        Wandermere,
        Aynor,
        Hull,
        Mestauskalio,
        Grasmere,
        Duncaster,
        Garmsby,
        Dumbarton;
    }
    
    private enum questType {
        artifact,
        container,
        riddle,
        shipment,
        strength;
    }

    // default constructor
    public Location() {
    }

    // public getter function
    public double getRow() {
        return row;
    }

    public double getColumn() {
        return column;
    }

    public Character getCharacter() {
        return character;
    }

    public boolean isQuestComplete() {
        return questComplete;
    }

    public boolean isPlayerPresent() {
        return playerPresent;
    }
    
    public ArtifactStrengthQuest getArtifactQuest() {
        return artifactQuest;
    }

    public ArtifactStrengthQuest getStrengthQuest() {
        return strengthQuest;
    }

    public RiddleQuest getRiddleQuest() {
        return riddleQuest;
    }

    public ShipmentQuest getShipmentQuest() {
        return shipmentQuest;
    }

    public StorageContainerQuest getStorageContainerQuest() {
        return storageContainerQuest;
    }

    public String getQuestType() {
        return questType;
    }
    
    // public setter function
    public void setRow(double row) {
        this.row = row;
    }

    public void setColumn(double column) {
        this.column = column;
    }

    public void setQuestComplete(boolean questComplete) {
        this.questComplete = questComplete;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setPlayerPresent(boolean playerPresent) {
        this.playerPresent = playerPresent;
    }

    public void setArtifactQuest(ArtifactStrengthQuest artifactQuest) {
        this.artifactQuest = artifactQuest;
    }

    public void setStrengthQuest(ArtifactStrengthQuest strengthQuest) {
        this.strengthQuest = strengthQuest;
    }

    public void setRiddleQuest(RiddleQuest riddleQuest) {
        this.riddleQuest = riddleQuest;
    }

    public void setShipmentQuest(ShipmentQuest shipmentQuest) {
        this.shipmentQuest = shipmentQuest;
    }

    public void setStorageContainerQuest(StorageContainerQuest storageContainerQuest) {
        this.storageContainerQuest = storageContainerQuest;
    }

    public void setQuestType(String questType) {
        this.questType = questType;
    }

    // public hashCode function
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.row) ^ (Double.doubleToLongBits(this.row) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.column) ^ (Double.doubleToLongBits(this.column) >>> 32));
        hash = 97 * hash + (this.questComplete ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.character);
        return hash;
    }
    
    // public toString function
    @Override
    public String toString() {
        return "Location{" + "row=" + row + ", column=" + column + ", questComplete=" + questComplete + ", character=" + character + '}';
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
        final Location other = (Location) obj;
        if (Double.doubleToLongBits(this.row) != Double.doubleToLongBits(other.row)) {
            return false;
        }
        if (Double.doubleToLongBits(this.column) != Double.doubleToLongBits(other.column)) {
            return false;
        }
        if (this.questComplete != other.questComplete) {
            return false;
        }
        if (this.character != other.character) {
            return false;
        }
        return true;
    }
    
}
