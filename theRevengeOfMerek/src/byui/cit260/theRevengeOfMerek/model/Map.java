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
    private String[] locations;
    
    // default constructor
    public Map() {
    }
    
    // public getter function
    public double getRowCount() {
        return rowCount;
    }
    
    public double getColumnCount() {
        return columnCount;
    }

    public String[] getLocations() {
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

    public void setLocations(String[] locations) {
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
