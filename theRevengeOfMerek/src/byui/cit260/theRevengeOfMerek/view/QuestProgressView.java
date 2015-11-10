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
            + "\n| (A)ctive Quests                 |"
            + "\n| (C)ompleted Quests              |"
            + "\n| (O)utstanding Quests            |"
            + "\n| (E)xit                          |"
            + "\n-----------------------------------");
    }

    // Execute the appropriate action based on input from user
    @Override
    public void doAction(Object obj) {
        char selection = (char) obj;
        
        switch(selection) {
            case 'A':
                this.displayActiveQuests();
                break;
            case 'C':
                this.displayCompletedQuests();
                break;
            case 'O':
                this.displayOutstandingQuests();
                break;
            case 'E':
                return;
            default:
                System.out.println("\n Invalid Selection, Try Again");
                break;
        }
    }

    private void displayActiveQuests() {
        System.out.println("displayActiveQuests method called!");
    }

    private void displayCompletedQuests() {
        System.out.println("displayCompletedQuests method called!");
    }

    private void displayOutstandingQuests() {
        System.out.println("displayOutstandingQuests method called!");
    }
}
