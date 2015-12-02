/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import byui.cit260.theRevengeOfMerek.control.InventoryControl;
import byui.cit260.theRevengeOfMerek.exceptions.InventoryControlException;
import byui.cit260.theRevengeOfMerek.model.InventoryItem;
import byui.cit260.theRevengeOfMerek.model.Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import therevengeofmerek.TheRevengeOfMerek;

/**
 *
 * @author maryelsmore
 */
public class InventoryMenuView {

    // Declare MENU Constant Variable
    private final String MENU = "|              Inventory Menu               |"
                            + "\n---------------------------------------------"
                            + "\n| (W) Change Weapons                        |"
                            + "\n| (A) Change Armor                          |"
                            + "\n| (S) Change Shields                        |"
                            + "\n| (B) Use Bandage                           |"
                            + "\n| (P) Use Potion                            |"
                            + "\n| (D) Display/Save Inventory Report         |"
                            + "\n| (E) Exit                                  |"
                            + "\n---------------------------------------------\n";
    private final BufferedReader keyboard = TheRevengeOfMerek.getInFile();
    private final PrintWriter console = TheRevengeOfMerek.getOutFile();
    
    // Display Menu and currently equipped items for the player
    public void display() {
        
        // Declare variables
        char selection = ' ';
        Player player = TheRevengeOfMerek.getPlayer();
        String playerName = player.getName();
        String equippedWeapon;
        String equippedArmor;
        String equippedShield;
        double health;
        
        // Loop to show and gather input from user in main menu
        do {
            // Refresh data from player information
            equippedWeapon = player.getWeapon();
            equippedArmor = player.getArmor();
            equippedShield = player.getShield();
            health = player.getHealth();
            
            // Display Character's equipped items
            this.console.print("\n---------------------------------------------"
                             + "\n| Character: " + playerName);
            int space = 31 - playerName.length();
            for (int i = 0; i < space; i++) {
                this.console.print(" ");
            }
            this.console.print("|");
            this.console.print("\n| Weapon: " + equippedWeapon);
            space = 34 - equippedWeapon.length();
            for (int i = 0; i < space; i++) {
                this.console.print(" ");
            }
            this.console.print("|");
            this.console.print("\n| Armor: " + equippedArmor);
            space = 35 - equippedArmor.length();
            for (int i = 0; i < space; i++) {
                this.console.print(" ");
            }
            this.console.print("|");
            this.console.print("\n| Shield: " + equippedShield);
            space = 34 - equippedShield.length();
            for (int i = 0; i < space; i++) {
                this.console.print(" ");
            }
            this.console.print("|");
            this.console.print("\n| Health: " + health);
            space = 34 - String.valueOf(health).length();
            for (int i = 0; i < space; i++) {
                this.console.print(" ");
            }
            this.console.print("|\n");
            
            // Print list of all inventory items
            this.displayAll();
            
            // Print the main menu
            this.console.print(MENU);
            
            // Gather input from the player
            String value = this.getInput();
            
            // Gather the first char from the input and capitalize it
            try {
                selection = Character.toUpperCase(value.charAt(0));
            } catch (IndexOutOfBoundsException ioo) {
                ErrorView.display(this.getClass().getName(), "Invalid option - please select from the menu above");
            }
            
            // Invoke the switches to execute the appropriate action
            this.doAction(selection);
       
        } while (selection != 'E');
        
    }
    
    // Method to gather the input from the user 
    public String getInput() {
        
        // Declare variables for getInput method
        boolean valid = false;
        String value = null;
        
        // Loop to gather input from user until they give valid input
        while (!valid) { 
            this.console.println("Select an option on the menu above");
            
            try {
                value = this.keyboard.readLine();
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Invalid option - please select from the menu above");
            }
            value = value.trim();
            
            if (value.length() == 0 || value.length() > 1) {
                ErrorView.display(this.getClass().getName(), "Invalid option - please select from the menu above");
            } else {
                valid = true;
            }
        
        }
        
        return value;
    }
    
    private Integer getInputInteger() {
        Integer value = null;
        this.console.println("Please enter the number of the item you wish to equip:");
        String input = null;
        
        while (value == null) {
            try {
                try {
                    // parse and convert number from text to double
                    input = this.keyboard.readLine();
                } catch (IOException ex) {
                    ErrorView.display(this.getClass().getName(), "You must enter a valid number. Please try again.");
                }
                value = Integer.parseInt(input);
            } catch (NumberFormatException nf) {
                ErrorView.display(this.getClass().getName(), "You must enter a valid number. Please try again.");
            }
        }
            
        return value;
    }
    
    // Execute the appropriate action based on input from user
    public void doAction(Object obj) {
        char selection = (char) obj;
        
        switch(selection) {
            case 'W':
                this.changeWAS("Weapon");
                break;
            case 'A':
                this.changeWAS("Armor");
                break;
            case 'S':
                this.changeWAS("Shield");
                break;
            case 'B':
                try {
                    InventoryControl.useBandagePotion("bandage");
                } catch (InventoryControlException ice) {
                    ErrorView.display(this.getClass().getName(), ice.getMessage());
                }
                break;
            case 'P':
                try {
                    InventoryControl.useBandagePotion("potion");
                } catch (InventoryControlException ice) {
                    ErrorView.display(this.getClass().getName(), ice.getMessage());
                }
                break;
            case 'D':
                this.inventoryReport();
                break;
            case 'E':
                return;
            default:
                ErrorView.display(this.getClass().getName(), "Invalid Selection, Try Again");
                break;
        }
    }
    
    private void changeWAS(String wasItemType) {
        
        // Get the player and sorted list of weapons for the current game
        Player player = TheRevengeOfMerek.getPlayer();
        ArrayList<InventoryItem> inventory;
        inventory = this.getSortedInventoryList(wasItemType);
        
        // Declare variables
        String name;
        String inventoryType;
        double quantity;
        boolean valid = false;
        
        // Display items of specific type and ask if they want to wear an item
        this.console.println("\nList of " + wasItemType +" Items\n"
                         + "=============================================\n"
                         + "Name" + "\t\t\t" + "Type" + "\t" + "Quantity\n"
                         + "=============================================");
        for (InventoryItem inventoryItem: inventory) {
            name = inventoryItem.getName();
            inventoryType = inventoryItem.getInventoryType();
            quantity = inventoryItem.getQuantity();
            if (inventoryType.equals(wasItemType.toLowerCase())) {
                this.console.print((inventory.indexOf(inventoryItem)+1) + ") ");
                this.console.print(name);
                int space = 21 - name.length();
                for (int i = 0; i < space; i++) {
                    this.console.print(" ");
                }
                this.console.println(inventoryType + "\t" + quantity);
            }
        }
        this.console.println("9) Exit");
        this.console.println("=============================================\n");
        do {
            int input = getInputInteger();
            input = --input;
            if (input != 8) {
                try {
                    InventoryItem newWAS = inventory.get(input);
                    valid = true;
                    if (wasItemType.toLowerCase().equals("weapon")) {
                        player.setWeapon(newWAS.getName());
                    } else if (wasItemType.toLowerCase().equals("armor")) {
                        player.setArmor(newWAS.getName());
                    } else if (wasItemType.toLowerCase().equals("shield")) {
                        player.setShield(newWAS.getName());
                    }
                } catch (IndexOutOfBoundsException ioo) {
                    ErrorView.display(this.getClass().getName(), "You must enter a valid number. Please try again.");
                }
            } else {
                valid = true;
            }
        } while (!valid);
        
    }
    
    private void displayAll() {
        
        // Get the sorted list of weapons for the current game
        ArrayList<InventoryItem> inventory;
        inventory = this.getSortedInventoryList("all");
        
        // Declare variables
        String name;
        String inventoryType;
        double quantity;
        
        // Display items of specific type and ask if they want to wear an item
        this.console.println("---------------------------------------------\n"
                           + "| List of all items                         |\n"
                           + "---------------------------------------------");
            this.console.printf("%-24s%-8s%-12s%1s%n", "| Name", "Type", "Quantity", "|");
            this.console.println("---------------------------------------------");
            for (InventoryItem inventoryItem : inventory) {
                name = inventoryItem.getName();
                inventoryType = inventoryItem.getInventoryType();
                quantity = inventoryItem.getQuantity();
                name = "| " + name;
                this.console.printf("%-24s%-8s%-12.0f%1s%n", name, inventoryType, quantity, "|");
            }
            this.console.println("---------------------------------------------");
        
    }

    public ArrayList<InventoryItem> getSortedInventoryList(String inventoryType) {
        
        // Get inventory list for the current game
        ArrayList<InventoryItem> originalInventoryList = TheRevengeOfMerek.getCurrentGame().getInventory();
        ArrayList<InventoryItem> inventoryList = new ArrayList<>();
        String newInventoryType;
        double newQuantity;
        String newName;
        
        // Clone original inventory list
        // WAS
        if (inventoryType.equals("Weapon") || inventoryType.equals("Armor") || inventoryType.equals("Shield")) {
            for (InventoryItem inventoryItem : originalInventoryList) {
                if (inventoryItem.getInventoryType().equals(inventoryType.toLowerCase())) {
                    newInventoryType = inventoryItem.getInventoryType();
                    newQuantity = inventoryItem.getQuantity();
                    newName = inventoryItem.getName();
                    inventoryList.add(new InventoryItem(newInventoryType, newQuantity, newName));
                }
            }
        }
        
        // Items
        if (inventoryType.equals("items")) {
            for (InventoryItem inventoryItem : originalInventoryList) {
                if (inventoryItem.getInventoryType().equals("bandage") || inventoryItem.getInventoryType().equals("potion") || inventoryItem.getInventoryType().equals("package")) {
                    newInventoryType = inventoryItem.getInventoryType();
                    newQuantity = inventoryItem.getQuantity();
                    newName = inventoryItem.getName();
                    inventoryList.add(new InventoryItem(newInventoryType, newQuantity, newName));
                }
            }
        }
        
        // All
        if (inventoryType.equals("all")) {
            inventoryList = new ArrayList<>(originalInventoryList);
        }
        
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

    private void inventoryReport() {
        
        // Display where to Save Game
        this.console.println("\n"
                + "\n------------------------------------"
                + "\n|      Save Inventory Report       |"
                + "\n|----------------------------------|"
                + "\n| Please enter the location you    |"
                + "\n| would like to save the           |"
                + "\n| inventory report:                |"
                + "\n------------------------------------"
                + "\n");
        
        // Wait for the user to press any key
        String input = null;
        try {
            input = this.keyboard.readLine();
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), "Invalid selection, please try again.");
        }
        
        // Save the game to the specified file
        try {
            this.saveInventoryReport(input);
            this.console.println("Report saved successfully!");
        } catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        
    }

    private void saveInventoryReport(String filePath) throws InventoryControlException {
        
        // Get the sorted list of weapons for the current game
        ArrayList<InventoryItem> inventory;
        inventory = this.getSortedInventoryList("all");
        
        // Declare variables
        String name;
        String inventoryType;
        double quantity;
        
        try (PrintWriter out = new PrintWriter(filePath)) {
        
            // Create an inventory report and save it to the specified file.
            out.println("---------------------------------------------\n"
                      + "| Inventory Report                          |\n"
                      + "---------------------------------------------");
            out.printf("%-24s%-8s%-12s%1s%n", "| Name", "Type", "Quantity", "|");
            out.println("---------------------------------------------");
            for (InventoryItem inventoryItem : inventory) {
                name = inventoryItem.getName();
                inventoryType = inventoryItem.getInventoryType();
                quantity = inventoryItem.getQuantity();
                name = "| " + name;
                out.printf("%-24s%-8s%-12.0f%1s%n", name, inventoryType, quantity, "|");
            }
            out.println("---------------------------------------------");
            
            // Display the same report to the screen
            this.displayAll();
            
        } catch (IOException ex) {
            throw new InventoryControlException("Failed to save inventory report.");
        }
        
    }
    
}