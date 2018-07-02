/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import largestproduct.calculo.Calculating;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 *
 * @author Vaio
 */
public class CalculatingTest {
    
    Calculating c;
    
    @Before
    public void before(){
        try{
            c = new Calculating(5, 10, 3675356291l);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    @Test
    public void getLargestProductTest(){
        try{
            
            long actual = c.getLargestProduct();
            
            assertEquals(3150, actual);
            
        }catch(Exception e){
            fail(e.getMessage());
        }
    }
    
    @Test
    public void getArrayDigits(){
        
        try{
            
            ArrayList<String> listActual = c.getArrayDigits();
            ArrayList<String> listExpected = new ArrayList<>();
            
            //3675356291
            listExpected.add("36753");
            listExpected.add("67535");
            listExpected.add("75356");
            listExpected.add("53562");
            listExpected.add("35629");
            listExpected.add("56291");
            
            
            Object[] actuals = listActual.toArray();
            Object[] expecteds = listExpected.toArray();
            
            assertArrayEquals(expecteds, actuals);
            
            
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
