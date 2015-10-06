/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revengeofmerek;

/**
 *
 * @author co075oh
 */
public class RevengeOfMerek {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}

public class Player implements Serializable {
    // class instance variables
    private String name;
    private double health;
    private String weapon;
    private String shield;
    private String armor;
    
    public Player() {
    }
}