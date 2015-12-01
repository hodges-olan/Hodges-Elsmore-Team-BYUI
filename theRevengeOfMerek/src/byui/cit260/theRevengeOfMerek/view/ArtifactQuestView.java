/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import byui.cit260.theRevengeOfMerek.model.Location;

/*This quest will be given to you from the Lord of each county.  A bandit has recently stolen a priceless
*artifact and to prove your loyalty to the county, you need to retrieve this item.  It will involve going to 
*the city mentioned in the question in which you will encounter the bandit.  The Battle Menu will then be 
*initialized and if you defeat the bandit, you will acquire the artifact.  This will complete the quest and 
gain more of the Lord’s trust.
*/

/**
 *
 * @author maryelsmore
 */
public class ArtifactQuestView {
    
    // Declare MENU Constant Variable
    private final String MENU = "\n"
                + "\n*********************************************************************"
                + "\n*                         Artifact Quest                            *"
                + "\n*********************************************************************"
                + "\n* We are so glad that you have come!  A bandit has recently stolen  *"
                + "\n* a pricessless artifact from our country. To prove your loyalty    *"
                + "\n* you need to battle the bandit and retrieve the item from them.    *"
                + "\n* Will you help us?                                                 *"
                + "\n*********************************************************************";
    
    // Method to display the welcome banner
    void displayMenu(Location location) {
    
        System.out.println("*** call artifact quest ***");
        
        // Declare variables
        char selection = ' ';
    
    }
}