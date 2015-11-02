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
        double resultDamage, resultDOT, weapon, strength, armor, expResultDamage, expResultDOT;
        double[] result;
        BattleControl instance = new BattleControl();
        
        /********************************
         * Test Case #1
         */
            // Declare test input and expected output
            weapon = 8.0;
            strength = 4.0;
            armor = 20.0;
            expResultDamage = 10.0;
            expResultDOT = 4.0; 
            System.out.println("\tTest case #1");
            result = instance.reduceHealthDOT(weapon, strength, armor);
            resultDamage = result[0];
            resultDOT = result[1];
            assertEquals(expResultDamage, resultDamage, 0.0);
            assertEquals(expResultDOT, resultDOT, 0.0);
    
        /********************************
         * Test Case #2
         */
            // Declare test input and expected output
            weapon = -1.0;
            strength = 10.0;
            armor = 10.0;
            expResultDamage = -1.0;
            expResultDOT = -1.0; 
            
            // Execute and Verify function
            System.out.println("\tTest case #2");
            result = instance.reduceHealthDOT(weapon, strength, armor);
            resultDamage = result[0];
            resultDOT = result[1];
            assertEquals(expResultDamage, resultDamage, 0.0);
            assertEquals(expResultDOT, resultDOT, 0.0);
            
        /********************************
         * Test Case #3
         */
            // Declare test input and expected output
            weapon = 10.0;
            strength = -1.0;
            armor = 5.0;
            expResultDamage = -1.0;
            expResultDOT = -1.0; 
            
            // Execute and Verify function
            System.out.println("\tTest case #3");
            result = instance.reduceHealthDOT(weapon, strength, armor);
            resultDamage = result[0];
            resultDOT = result[1];
            assertEquals(expResultDamage, resultDamage, 0.0);
            assertEquals(expResultDOT, resultDOT, 0.0);
            
        /********************************
         * Test Case #4
         */
            // Declare test input and expected output
            weapon = 4.0;
            strength = 6.0;
            armor = -1.0;
            expResultDamage = -1.0;
            expResultDOT = -1.0; 
            
            // Execute and Verify function
            System.out.println("\tTest case #4");
            result = instance.reduceHealthDOT(weapon, strength, armor);
            resultDamage = result[0];
            resultDOT = result[1];
            assertEquals(expResultDamage, resultDamage, 0.0);
            assertEquals(expResultDOT, resultDOT, 0.0);
            
        /********************************
         * Test Case #5
         */
            // Declare test input and expected output
            weapon = 0.0;
            strength = 12.0;
            armor = 7.0;
            expResultDamage = -1.0;
            expResultDOT = -1.0; 
            
            // Execute and Verify function
            System.out.println("\tTest case #5");
            result = instance.reduceHealthDOT(weapon, strength, armor);
            resultDamage = result[0];
            resultDOT = result[1];
            assertEquals(expResultDamage, resultDamage, 0.0);
            assertEquals(expResultDOT, resultDOT, 0.0);
            
        /********************************
         * Test Case #6
         */
            // Declare test input and expected output
            weapon = 9.0;
            strength = 0.0;
            armor = 3.0;
            expResultDamage = -1.0;
            expResultDOT = -1.0; 
            
            // Execute and Verify function
            System.out.println("\tTest case #6");
            result = instance.reduceHealthDOT(weapon, strength, armor);
            resultDamage = result[0];
            resultDOT = result[1];
            assertEquals(expResultDamage, resultDamage, 0.0);
            assertEquals(expResultDOT, resultDOT, 0.0);
            
        /********************************
         * Test Case #7
         */
            // Declare test input and expected output
            weapon = 3.0;
            strength = 2.0;
            armor = 0.0;
            expResultDamage = -1.0;
            expResultDOT = -1.0; 
            
            // Execute and Verify function
            System.out.println("\tTest case #7");
            result = instance.reduceHealthDOT(weapon, strength, armor);
            resultDamage = result[0];
            resultDOT = result[1];
            assertEquals(expResultDamage, resultDamage, 0.0);
            assertEquals(expResultDOT, resultDOT, 0.0);
            
        /********************************
         * Test Case #8
         */
            // Declare test input and expected output
            weapon = 1.0;
            strength = 8.0;
            armor = 2.0;
            expResultDamage = 5.0;
            expResultDOT = 2.0; 
            
            // Execute and Verify function
            System.out.println("\tTest case #8");
            result = instance.reduceHealthDOT(weapon, strength, armor);
            resultDamage = result[0];
            resultDOT = result[1];
            assertEquals(expResultDamage, resultDamage, 0.0);
            assertEquals(expResultDOT, resultDOT, 0.0);
            
        /********************************
         * Test Case #9
         */
            // Declare test input and expected output
            weapon = 11.0;
            strength = 1.0;
            armor = 7.0;
            expResultDamage = 3.0;
            expResultDOT = 1.0; 
            
            // Execute and Verify function
            System.out.println("\tTest case #9");
            result = instance.reduceHealthDOT(weapon, strength, armor);
            resultDamage = result[0];
            resultDOT = result[1];
            assertEquals(expResultDamage, resultDamage, 0.0);
            assertEquals(expResultDOT, resultDOT, 0.0);
        
        /********************************
         * Test Case #10
         */
            // Declare test input and expected output
            weapon = 10.0;
            strength = 8.0;
            armor = 1.0;
            expResultDamage = 63.0;
            expResultDOT = 24.0; 
            
            // Execute and Verify function
            System.out.println("\tTest case #10");
            result = instance.reduceHealthDOT(weapon, strength, armor);
            resultDamage = result[0];
            resultDOT = result[1];
            assertEquals(expResultDamage, resultDamage, 0.0);
            assertEquals(expResultDOT, resultDOT, 0.0);

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
