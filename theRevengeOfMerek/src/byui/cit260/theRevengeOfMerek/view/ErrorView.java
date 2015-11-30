/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.view;

import java.io.PrintWriter;
import therevengeofmerek.TheRevengeOfMerek;

/**
 *
 * @author co075oh
 */
public class ErrorView {
    
    // Define variables
    private static final PrintWriter errorFile = TheRevengeOfMerek.getOutFile();
    
    //Display error message
    public static void display(String className, String errorMessage) {
        errorFile.println("\n"
                        + "---------------------------------------------\n"
                        + "- ERROR - " + errorMessage + "\n"
                        + "---------------------------------------------\n");
    }
    
}
