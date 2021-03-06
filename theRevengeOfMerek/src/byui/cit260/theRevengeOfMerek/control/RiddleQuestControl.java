/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.control;

import byui.cit260.theRevengeOfMerek.exceptions.RiddleQuestControlException;

/**
 *
 * @author co075oh
 */
public class RiddleQuestControl {
    
    // Method for verifying the answer the player gave is correct
    public static boolean isRiddleAnswerCorrect (String answer, String playerAnswer) throws RiddleQuestControlException {
        
        // Capitalize answers in preparation for compare function
        answer = answer.toUpperCase();
        playerAnswer = playerAnswer.toUpperCase();
        boolean correct = false;
        
        // Compare values and execute accordingly
        if (answer.equals(playerAnswer)) {
            correct = true;
        } else {
            throw new RiddleQuestControlException ("Wrong answer, guess again!");
        }
        
        return correct;
        
    }
    
}
