/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import java.util.Scanner;

/**
 *
 * @author maryelsmore
 */
public class InventoryMenuView extends View {

    // Declare MENU Constant Variable
    public InventoryMenuView() {
        super("\n"
            + "\n-----------------------------------"
            + "\n|      Inventory Menu             |"
            + "\n-----------------------------------"
            + "\n| (W)eapons                       |"
            + "\n| (A)rmors                        |"
            + "\n| (S)hields                       |"
            + "\n| (H)elp                          |"
            + "\n| (E)xit                          |"
            + "\n-----------------------------------");
    } 
    
    // Execute the appropriate action based on input from user
    @Override
    public void doAction(Object obj) {
        char selection = (char) obj;
        
        switch(selection) {
            case 'W':
                this.displayWeapons();
                break;
            case 'A':
                this.displayArmors();
                break;
            case 'S':
                this.displayShields();
                break;
            case 'H':
                this.displayHelpMenu();
                break;
            case 'E':
                return;
            default:
                System.out.println("\n Invalid Selection, Try Again");
                break;
        }
    }
    
    private void displayWeapons() {
        System.out.println("The displayWeapons method was called!");
    }

    private void displayArmors() {
        System.out.println("The displayArmors method was called!");
    }

    private void displayShields() {
        System.out.println("The displayShields method was called!");
    }
    
    // Method to display the help menu
    private void displayHelpMenu() {
        
    // Create and display the game menu
    HelpMenuView helpMenu = new HelpMenuView();
    helpMenu.display();
    }    
       
}
