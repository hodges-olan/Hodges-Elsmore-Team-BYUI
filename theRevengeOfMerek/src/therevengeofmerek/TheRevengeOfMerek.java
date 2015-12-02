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

/**
 *
 * @author maryelsmore
 */
public class TheRevengeOfMerek {

    // Variable declaration
    private static Game currentGame = null;
    
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    private static PrintWriter logFile = null;
    
    // Main Method for TheRevengeOfMerek Game
    public static void main(String[] args) {
        
       try {
           
           // Open character stream files for end user input and output
           TheRevengeOfMerek.inFile = new BufferedReader(new InputStreamReader(System.in));
           TheRevengeOfMerek.outFile = new PrintWriter(System.out, true);
           
           // Open log file
           String filePath = "log.txt";
           TheRevengeOfMerek.logFile = new PrintWriter(filePath);
           
           // Create StartProgramView and start the program
           StartProgramView startProgramView = new StartProgramView();
           startProgramView.startProgram();
           
       } catch (Throwable te) {
           
           System.out.println("\nException: " + te.toString()
                            + "\nCause: " + te.getCause()
                            + "\nMessage: " + te.getMessage());
           te.printStackTrace();
           
       } finally {
           
           try {
               
               if (TheRevengeOfMerek.inFile != null) {
                   TheRevengeOfMerek.inFile.close();
               }
               if (TheRevengeOfMerek.outFile != null) {
                   TheRevengeOfMerek.outFile.close();
               }
               if (TheRevengeOfMerek.logFile != null) {
                   TheRevengeOfMerek.logFile.close();
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

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    // Setter methods
    public static void setCurrentGame(Game currentGame) {
        TheRevengeOfMerek.currentGame = currentGame;
    }

    public static void setOutFile(PrintWriter outFile) {
        TheRevengeOfMerek.outFile = outFile;
    }

    public static void setInFile(BufferedReader inFile) {
        TheRevengeOfMerek.inFile = inFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        TheRevengeOfMerek.logFile = logFile;
    }
    
}