/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import byui.cit260.theRevengeOfMerek.model.Location;

/*To prove your strength, the Lord asks you to duel his best warrior.  This will initialize the Battle menu in
 *which you will engage the warrior.  If you defeat the warrior, you will complete the quest and gain more 
 *of the Lord’s trust.
 */

/**
 *
 * @author maryelsmore
 */
public class StrengthQuestView {

    // Declare MENU Constant Variable
    private final String MENU = "\n"
                + "\n*********************************************************************"
                + "\n*                         Strength Quest                            *"
                + "\n*********************************************************************"
                + "\n* It's time to prove your strength!  We would like you to duel      *"
                + "\n* the best warrior from our country to show how strong you are.     *"
                + "\n*                                                                   *"
                + "\n* Are you up for the challenge?                                     *"
                + "\n*********************************************************************";
    
    void displaymenu(Location location) {
        System.out.println("*** call strength quest ***");
    }
    
}
