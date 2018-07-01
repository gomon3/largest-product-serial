/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import largestproduct.Calculating;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vaio
 */
public class CalculatingTest {
    
    @Test
    public void getLargestProductTest(){
        Calculating c = new Calculating();
        
        try{
            //c.setNumber(3675356291l);
            long actual = c.getLargestProduct();
            
            assertEquals(3150, actual);
            
        }catch(Exception e){
            fail(e.getMessage());
        }
    }
    
   

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
