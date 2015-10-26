/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theRevengeOfMerek.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author co075oh
 */
public class BattleControlTest {
    
    public BattleControlTest() {
    }

    /**
     * Test of reduceHealthDOT method, of class BattleControl.
     */
    @Test
    public void testReduceHealthDOT() {
        System.out.println("\nreduceHealthDOT");
        
        // Declare variables
        double resultDamage, resultDOT;
        double[] result;
        BattleControl instance = new BattleControl();
        
        // Declare test input and expected output
        double[] weapon = {8.0, -1.0, 10.0, 4.0, 0.0, 9.0, 3.0, 1.0, 11.0, 10.0};
        double[] strength = {4.0, 10.0, -1.0, 6.0, 12.0, 0.0, 2.0, 8.0, 1.0, 8.0};
        double[] armor = {20.0, 10.0, 5.0, -1.0, 7.0, 3.0, 0.0, 2.0, 7.0, 1.0};
        double[] expResultDamage = {10.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, 5.0, 3.0, 63.0};
        double[] expResultDOT = {4.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, 2.0, 1.0, 24.0}; 
        
        /********************************
         * Test Case Loop
         */
        for (int i = 0; i < 10; i++) {
            System.out.println("\tTest case #" + (i+1));
            result = instance.reduceHealthDOT(weapon[i], strength[i], armor[i]);
            resultDamage = result[0];
            resultDOT = result[1];
            assertEquals(expResultDamage[i], resultDamage, 0.0);
            assertEquals(expResultDOT[i], resultDOT, 0.0);
        }

    }

    /**
     * Test of reduceHealthNormal method, of class BattleControl.
     */
    @Test
    public void testReduceHealthNormal() {
        System.out.println("\nreduceHealthNormal");
        
        // Declare variables
        double result;
        BattleControl instance = new BattleControl();
        
        // Declare test input and expected output
        double[] weapon = {8.0, -1.0, 10.0, 4.0, 0.0, 9.0, 3.0, 1.0, 11.0, 10.0};
        double[] strength = {4.0, 10.0, -1.0, 6.0, 12.0, 0.0, 2.0, 8.0, 1.0, 8.0};
        double[] armor = {20.0, 10.0, 5.0, -1.0, 7.0, 3.0, 0.0, 2.0, 7.0, 1.0};
        double[] expResult = {12.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, 6.0, 4.0, 79.0};
        
        /********************************
         * Test Case Loop
         */
        for (int i = 0; i < 10; i++) {
            System.out.println("\tTest case #" + (i+1));
            result = instance.reduceHealthNormal(weapon[i], strength[i], armor[i]);
            assertEquals(expResult[i], result, 0.0);
        }
        
    }
    
}
