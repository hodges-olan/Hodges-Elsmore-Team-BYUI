/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.exceptions;

/**
 *
 * @author co075oh
 */
public class ShipmentQuestControlException extends Exception {

    public ShipmentQuestControlException() {
    }

    public ShipmentQuestControlException(String message) {
        super(message);
    }

    public ShipmentQuestControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShipmentQuestControlException(Throwable cause) {
        super(cause);
    }

    public ShipmentQuestControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
