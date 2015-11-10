/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

/**
 *
 * @author co075oh
 */
public class QuestProgressView extends View {
    
// Declare MENU Constant Variable
    public QuestProgressView() {
        super("\n"
            + "\n-----------------------------------"
            + "\n|       Quest Progress Menu       |"
            + "\n-----------------------------------"
            + "\n| Quest Progress will be shown    |"
            + "\n| Here as we implement the rest   |"
            + "\n| the rest of the game            |"
            + "\n|---------------------------------|"
            + "\n| (E)xit                          |"
            + "\n-----------------------------------");
    }

    // Execute the appropriate action based on input from user
    @Override
    public void doAction(Object obj) {
        char selection = (char) obj;
        
        switch(selection) {
            case 'E':
                return;
            default:
                System.out.println("\n Invalid Selection, Try Again");
                break;
        }
    }
}
