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
    
    // default constructor
    public Map() {
    }

    public Map(int i, int i0) {
        System.out.println("*** called Map() in Map ***");
    }
    
    // public getter function
    public double getRowCount() {
        return rowCount;
    }
    
    public double getColumnCount() {
        return columnCount;
    }
    
    // public setter function
    public void setRowCount(double rowCount) {
        this.rowCount = rowCount;
    } 
    
    // public setter function
    public void setColumnCount(double columnCount) {
        this.columnCount = columnCount;
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
