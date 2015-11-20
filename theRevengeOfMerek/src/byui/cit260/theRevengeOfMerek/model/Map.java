/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author co075oh
 */
public class Map implements Serializable {
    
    // class instance variables
    private int rowCount;
    private int columnCount;
    private Location[][] locations;
    
    // default constructor
    public Map(int noOfRows, int noOfColumns) {
        
        // Error Checking
        if (noOfRows < 1 || noOfColumns < 1) {
            System.out.println("The number of rows and columns must be > zero");
            return;
        }
        
        // Set rows and columns values
        this.rowCount = noOfRows;
        this.columnCount = noOfColumns;
        
        // Create 2D array for Location objects
        this.locations = new Location[noOfRows][noOfColumns];
        
        // Create, initialize, and assign location objects to position on map
        for (int row = 0; row < noOfRows; row++) {
            for (int column = 0; column < noOfColumns; column++) {
                Location location = new Location();
                location.setColumn(column);
                location.setRow(row);
                location.setQuestComplete(false);
                locations[row][column] = location;
            }
        }
        
    }
    
    // public getter function
    public int getRowCount() {
        return rowCount;
    }
    
    public int getColumnCount() {
        return columnCount;
    }

    public Location[][] getLocations() {
        return locations;
    }
    
    // public setter function
    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    } 
    
    // public setter function
    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }    

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }

    // public hashCode function
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.rowCount;
        hash = 37 * hash + this.columnCount;
        hash = 37 * hash + Arrays.deepHashCode(this.locations);
        return hash;
    } 

    // public toString function
    @Override
    public String toString() {
        return "Map{" + "rowCount=" + rowCount + ", columnCount=" + columnCount + ", locations=" + locations + '}';
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
        final Map other = (Map) obj;
        if (this.rowCount != other.rowCount) {
            return false;
        }
        if (this.columnCount != other.columnCount) {
            return false;
        }
        if (!Arrays.deepEquals(this.locations, other.locations)) {
            return false;
        }
        return true;
    }
    
}
