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
import therevengeofmerek.TheRevengeOfMerek;

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
                this.displayArmor();
                break;
            case 'S':
                this.displayShields();
                break;
            case 'I':
                this.displayItems();
                break;
            case 'E':
                return;
            default:
                System.out.println("\n Invalid Selection, Try Again");
                break;
        }
    }
    
    private void displayWeapons() {
        
        // Get the sorted list of weapons for the current game
        ArrayList<InventoryItem> inventory;
        inventory = this.getSortedInventoryList();
        
        // Display the sorted weapon list
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
            if (inventoryType.equals("weapon")) {
                System.out.print(name);
                int space = 16 - name.length();
                for (int i = 0; i < space; i++) {
                    System.out.print(" ");
                }
                System.out.println(inventoryType + "\t" + quantity);
            }
        }
        
    }

    private void displayArmor() {
        
        // Get the sorted list of shields for the current game
        ArrayList<InventoryItem> inventory;
        inventory = this.getSortedInventoryList();
        
        // Display the sorted armor list
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
            if (inventoryType.equals("armor")) {
                System.out.print(name);
                int space = 16 - name.length();
                for (int i = 0; i < space; i++) {
                    System.out.print(" ");
                }
                System.out.println(inventoryType + "\t" + quantity);
            }
        }
        
    }

    private void displayShields() {
        
        // Get the sorted list of shields for the current game
        ArrayList<InventoryItem> inventory;
        inventory = this.getSortedInventoryList();
        
        // Display the sorted shield list
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
            if (inventoryType.equals("shield")) {
                System.out.print(name);
                int space = 16 - name.length();
                for (int i = 0; i < space; i++) {
                    System.out.print(" ");
                }
                System.out.println(inventoryType + "\t" + quantity);
            }
        }
        
    }
    
    private void displayItems() {
        
        // Get the sorted list of inventory items for the current game
        ArrayList<InventoryItem> inventory;
        inventory = this.getSortedInventoryList();
        
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
                System.out.print(name);
                int space = 16 - name.length();
                for (int i = 0; i < space; i++) {
                    System.out.print(" ");
                }
                System.out.println(inventoryType + "\t" + quantity);
            }
        }
        
    }   

    public ArrayList<InventoryItem> getSortedInventoryList() {
        
        // Get inventory list for the current game
        ArrayList<InventoryItem> originalInventoryList = TheRevengeOfMerek.getCurrentGame().getInventory();
        
        // Clone original inventory list
        ArrayList<InventoryItem> inventoryList = new ArrayList(originalInventoryList);
        
        // Sorting inventory list by name with bubble sort
        InventoryItem tempInventoryItem;
        for (int i = 0; i < inventoryList.size()-1; i++) {
            for (int j = 0; j < inventoryList.size()-1-i; j++) {
                if ((inventoryList.get(j)).getName().compareToIgnoreCase((inventoryList.get(j+1).getName())) > 0) {
                    tempInventoryItem = inventoryList.get(j);
                    inventoryList.set(j, inventoryList.get(j+1));
                    inventoryList.set(j+1, tempInventoryItem);
                }
            }
        }
        
        // Return the sorted inventory list
        return inventoryList;
        
    }
    
}