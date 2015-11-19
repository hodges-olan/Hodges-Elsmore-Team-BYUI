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
public class Map implements Serializable {
    
    // class instance variables
    private double rowCount;
    private double columnCount;
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
            }
        }
        
    }
    
    // public getter function
    public double getRowCount() {
        return rowCount;
    }
    
    public double getColumnCount() {
        return columnCount;
    }

    public Location[][] getLocations() {
        return locations;
    }
    
    // public setter function
    public void setRowCount(double rowCount) {
        this.rowCount = rowCount;
    } 
    
    // public setter function
    public void setColumnCount(double columnCount) {
        this.columnCount = columnCount;
    }    

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }

    // public hashCode function
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.rowCount) ^ (Double.doubleToLongBits(this.rowCount) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.columnCount) ^ (Double.doubleToLongBits(this.columnCount) >>> 32));
        return hash;
    }

    // public toString function
    @Override
    public String toString() {
        return "Map{" + "rowCount=" + rowCount + ", columnCount=" + columnCount + '}';
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
        if (Double.doubleToLongBits(this.rowCount) != Double.doubleToLongBits(other.rowCount)) {
            return false;
        }
        if (Double.doubleToLongBits(this.columnCount) != Double.doubleToLongBits(other.columnCount)) {
            return false;
        }
        return true;
    }
    
}
