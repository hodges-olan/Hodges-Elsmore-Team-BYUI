/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package therevengeofmerek;

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
    
    // public getter function
    public double getRowCount() {
        return rowCount;
    }
    
    // public setter function
    public void setRowCount(double rowCount) {
        this.rowCount = rowCount;
    } 
    
    // public getter function
    public double getColumnCount() {
        return columnCount;
    }
    
    // public setter function
    public void setColumnCount(double columnCount) {
        this.columnCount = columnCount;
    }    
    
}
