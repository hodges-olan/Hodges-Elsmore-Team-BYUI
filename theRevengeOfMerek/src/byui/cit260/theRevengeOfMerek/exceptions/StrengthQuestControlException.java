/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.exceptions;

/**
 *
 * @author maryelsmore
 */
public class StrengthQuestControlException extends Exception {

    public StrengthQuestControlException() {
    }

    public StrengthQuestControlException(String message) {
        super(message);
    }

    public StrengthQuestControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public StrengthQuestControlException(Throwable cause) {
        super(cause);
    }

    public StrengthQuestControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
