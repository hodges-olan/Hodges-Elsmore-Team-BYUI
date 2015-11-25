/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import byui.cit260.theRevengeOfMerek.control.GameControl;
import byui.cit260.theRevengeOfMerek.model.InventoryItem;
import java.util.ArrayList;
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
            + "\n| (A)rmor                         |"
            + "\n| (S)hields                       |"
            + "\n| (I)tems                         |"
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
            case 'I':
                this.displayItems();
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
        System.out.println("The displayArmor method was called!");
    }

    private void displayShields() {
        System.out.println("The displayShields method was called!");
    }
    
    private void displayItems() {
        
        // Get the sorted list of inventory items for the current game
        ArrayList<InventoryItem> inventory = GameControl.getSortedInventoryList();
        
        // Display the sorted inventory list
        String name;
        String inventoryType;
        double quantity;
        System.out.println("\nList of Inventory Items");
        System.out.println("Name" + "\t\t" +
                "Type" + "\t" +
                "Quantity");
        for (InventoryItem inventoryItem: inventory) {
            name = inventoryItem.getName();
            inventoryType = inventoryItem.getInventoryType();
            quantity = inventoryItem.getQuantity();
            if (inventoryType.equals("bandage") || inventoryType.equals("potion")) {
                System.out.print(inventoryItem.getName());
                int space = 16 - inventoryItem.getName().length();
                for (int i = 0; i < space; i++) {
                    System.out.print(" ");
                }
                System.out.println(inventoryItem.getInventoryType() + "\t" + inventoryItem.getQuantity());
            }
        }
    }
    
    // Method to display the help menu
    private void displayHelpMenu() {
        
    // Create and display the game menu
    HelpMenuView helpMenu = new HelpMenuView();
    helpMenu.display();
    }    
       
}
