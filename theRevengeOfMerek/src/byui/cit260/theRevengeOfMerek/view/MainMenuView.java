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
public class MainMenuView {
    
    private final String MENU = "\n"
            + "\n-----------------------------------"
            + "\n Main Menu"
            + "\n-----------------------------------"
            + "\n (N)ew Game"
            + "\n (S)ave Game"
            + "\n (C)ontinue Game"
            + "\n (H)elp"
            + "\n (E)xit"
            + "\n-----------------------------------";
    
    void displayMenu() {
        
        char selection = ' ';
        do {
            System.out.println(MENU);
            
            String input = this.getInput();
            selection = input.charAt(0);
            
            this.doAction(selection);
       
        } while (selection != 'E');
    }

    private String getInput() {
        boolean valid = false;
        String input = null;
        Scanner keyboard = new Scanner(System.in);
        
        do { 
            System.out.println("Select an Option on the Main Menu");
            
            input = keyboard.nextLine();
            input = input.trim();
            
            if (input.length() == 0 || input.length() > 1) {
                System.out.println("Invalid option - please select from the Menu Above");
         
            } else {
                valid = true;
            }
        
        } while(!valid);
        return input;
    } 
    

    private void doAction(char selection) {
        switch (selection) {
            case 'N':
                this.startNewGame();
                break;
            case 'S':
                this.saveGame();
                break;
            case 'C':
                this.retrieveGame();
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

    private void startNewGame() {
        
    }

    private void retrieveGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void displayHelpMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void saveGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
