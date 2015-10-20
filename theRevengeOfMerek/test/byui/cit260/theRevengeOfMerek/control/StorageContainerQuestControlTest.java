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
public class StorageContainerQuestControlTest {
    
    public StorageContainerQuestControlTest() {
    }

    /**
     * Test of calculateVolume method, of class StorageContainerQuestControl.
     */
    @Test
    public void testCalculateVolume() {
        System.out.println("calculateVolume");
        
        /********************************
         * Test Case #1
         */
        System.out.println("\tTest case #1");
        double radius = 4.0;
        double height = 8.0;
        double reqVolume = 402.0;
        StorageContainerQuestControl instance = new StorageContainerQuestControl();
        boolean expResult = true;
        boolean result = instance.calculateVolume(radius, height, reqVolume);
        assertEquals("Passed", expResult, result);
        
        /********************************
         * Test Case #2
         */
        System.out.println("\tTest case #2");
        radius = 10.0;
        height = -1.0;
        reqVolume = 200.0;
        expResult = false;
        result = instance.calculateVolume(radius, height, reqVolume);
        assertEquals("Passed", expResult, result);
        
        /********************************
         * Test Case #3
         */
        System.out.println("\tTest case #3");
        radius = -1.0;
        height = 10.0;
        reqVolume = 200.0;
        expResult = false;
        result = instance.calculateVolume(radius, height, reqVolume);
        assertEquals("Passed", expResult, result);
        
        /********************************
         * Test Case #4
         */
        System.out.println("\tTest case #4");
        radius = 12.0;
        height = 0.0;
        reqVolume = 200.0;
        expResult = false;
        result = instance.calculateVolume(radius, height, reqVolume);
        assertEquals("Passed", expResult, result);
        
        /********************************
         * Test Case #5
         */
        System.out.println("\tTest case #5");
        radius = 0.0;
        height = 9.0;
        reqVolume = 200.0;
        expResult = false;
        result = instance.calculateVolume(radius, height, reqVolume);
        assertEquals("Passed", expResult, result);
        
        /********************************
         * Test Case #6
         */
        System.out.println("\tTest case #6");
        radius = 8.0;
        height = 1.0;
        reqVolume = 201.0;
        expResult = true;
        result = instance.calculateVolume(radius, height, reqVolume);
        assertEquals("Passed", expResult, result);
        
        /********************************
         * Test Case #7
         */
        System.out.println("\tTest case #7");
        radius = 1.0;
        height = 11.0;
        reqVolume = 34.0;
        expResult = true;
        result = instance.calculateVolume(radius, height, reqVolume);
        assertEquals("Passed", expResult, result);
        
    }
    
}
