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
public class ArtifactQuestControlException extends Exception {

    public ArtifactQuestControlException() {
    }

    public ArtifactQuestControlException(String message) {
        super(message);
    }

    public ArtifactQuestControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArtifactQuestControlException(Throwable cause) {
        super(cause);
    }

    public ArtifactQuestControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
