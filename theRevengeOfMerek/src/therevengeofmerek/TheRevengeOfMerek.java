/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package therevengeofmerek;

import byui.cit260.theRevengeOfMerek.model.Game;
import byui.cit260.theRevengeOfMerek.model.Player;
import byui.cit260.theRevengeOfMerek.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maryelsmore
 */
public class TheRevengeOfMerek {

    // Variable declaration
    private static Game currentGame = null;
    private static Player player = null;
    
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    
    // Main Method for TheRevengeOfMerek Game
    public static void main(String[] args) {
       StartProgramView startProgramView = new StartProgramView();
       try {
           
           // Open character stream files for end user input and output
           TheRevengeOfMerek.inFile = new BufferedReader(new InputStreamReader(System.in));
           TheRevengeOfMerek.outFile = new PrintWriter(System.out, true);
           
           // Create StartProgramView and start the program
           startProgramView.startProgram();
       } catch (Throwable te) {
           System.out.println("\nException: " + te.toString()
                            + "\nCause: " + te.getCause()
                            + "\nMessage: " + te.getMessage());
           te.printStackTrace();
           startProgramView.startProgram();
       } finally {
           try {
               if (TheRevengeOfMerek.inFile != null) {
                   TheRevengeOfMerek.inFile.close();
               }
               if (TheRevengeOfMerek.outFile != null) {
                   TheRevengeOfMerek.outFile.close();
               }
           } catch (IOException ex) {
               System.out.println("Error closing files");
               return;
           }
       }
    }
    
    // Getter methods
    public static Game getCurrentGame() {
        return currentGame;
    }
    
    public static Player getPlayer() {
        return player;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    // Setter methods
    public static void setCurrentGame(Game currentGame) {
        TheRevengeOfMerek.currentGame = currentGame;
    }

    public static void setPlayer(Player player) {
        TheRevengeOfMerek.player = player;
    }

    public static void setOutFile(PrintWriter outFile) {
        TheRevengeOfMerek.outFile = outFile;
    }

    public static void setInFile(BufferedReader inFile) {
        TheRevengeOfMerek.inFile = inFile;
    }
    
}