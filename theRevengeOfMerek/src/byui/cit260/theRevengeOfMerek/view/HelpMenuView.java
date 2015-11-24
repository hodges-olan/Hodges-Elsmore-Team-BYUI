/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import java.util.Scanner;

/**
 *
 * @author co075oh
 */
public class HelpMenuView extends View {

    // Declare MENU Constant Variable
    public HelpMenuView() {
        super("\n"
            + "\n-----------------------------------"
            + "\n|           Help Menu             |"
            + "\n-----------------------------------"
            + "\n| (G)oal of the game              |"
            + "\n| (U)ser Consoel - Game Console   |"
            + "\n| (E)xit                          |"
            + "\n-----------------------------------");
    }

    // Execute the appropriate action based on input from user
    @Override
    public void doAction(Object obj) {
        char selection = (char) obj;
        
        switch(selection) {
            case 'G':
                this.displayGoalHelp();
                break;
            case 'U':
                this.displayUserConsoleHelp();
                break;
            case 'E':
                return;
            default:
                System.out.println("\n Invalid Selection, Try Again");
                break;
        }
    }

    private void displayGoalHelp() {
        
        // Display the Goal of the Game help text
        System.out.println("\n"
                + "\n------------------------------------"
                + "\n|         Goal of the Game         |"
                + "\n|----------------------------------|"
                + "\n| To seat Merek back in his throne |"
                + "\n| you will need to complete all    |"
                + "\n| five quests in all five counties |"
                + "\n| which will gain you trust with   |"
                + "\n| each Lord.                       |"
                + "\n| Once you have gained the trust   |"
                + "\n| of all five Lords, you will then |"
                + "\n| have the necessary forces to     |"
                + "\n| overthrow Worthag and beat the   |"
                + "\n| game.                            |"
                + "\n-----------------------------------|"
                + "\n\nPress any key to return to the Help menu");
        
        // Wait for the user to press any key
        String input = null;
        Scanner keyboard = new Scanner(System.in);
        input = keyboard.nextLine();
        
    }
    
    private void displayUserConsoleHelp() {
        
        // Display the Goal of the Game help text
        System.out.println("\n"
                + "\n------------------------------------"
                + "\n|        User Console Help         |"
                + "\n|----------------------------------|"
                + "\n| (I)nventory will show all items  |"
                + "\n| presently in your inventory.     |"
                + "\n|                                  |"
                + "\n| (Q)uests will display the quests |"
                + "\n| you have to complete to beat the |"
                + "\n| game and their status, either    |"
                + "\n| Complete or Unfinished.          |"
                + "\n|                                  |"
                + "\n| (M)ove gives you the menu where  |"
                + "\n| you can move from city to city.  |"
                + "\n|                                  |"
                + "\n| (S)ave will save your current    |"
                + "\n| progress.                        |"
                + "\n|                                  |"
                + "\n| (H)elp will display the help     |"
                + "\n| menu.                            |"
                + "\n|                                  |"
                + "\n| (E)xit will exit the game.       |"
                + "\n-----------------------------------|"
                + "\n\nPress any key to return to the Help menu");
        
        // Wait for the user to press any key
        String input = null;
        Scanner keyboard = new Scanner(System.in);
        input = keyboard.nextLine();
        
    }

}