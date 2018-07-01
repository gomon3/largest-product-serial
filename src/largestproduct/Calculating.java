/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largestproduct;

import java.util.ArrayList;

/**
 *
 * @author Vaio
 */
public class Calculating {
    
    private int k;
    private int nDig;
    private long n;
    
    private boolean nDefined = false;
    
    public Calculating(){
        this.k = 5;
        this.nDig = 10;
        this.nDefined = false;
    }
    
    public Calculating(int k, int nDig){
        this.k = k;
        this.nDig = nDig;
        this.nDefined = false;
    }
    
    public Calculating(int k, int nDig, long n) throws Exception {
        this.k = k;
        this.nDig = nDig;
        setNumber(n);   
        this.nDefined = true;
    }
    
    protected void setK(int k){
        this.k = k;
    }
    
    protected void setNoDigit(int nDig){
        this.nDig = nDig;
    }
    
    protected int getK(){
        return this.k;
    }
    
    protected int getNoDigit(){
        return this.nDig;
    }
    
    
    public void setNumber(long n) throws Exception {
           
        if(Long.toString(n).length() != this.nDig){
            
            throw new Exception("El número ingresado no cumple con el número de dígitos establecido No. Dígitos: " + this.nDig);
            
        }else{
            
            this.n = n;
            this.nDefined = true;
            
        }
        
    }
    
    public long getLargestProduct() throws Exception {
        ArrayList<String> arr = getArrayDigits();
        long largestProduct = -10000000000l;
        long temp = 0;
        
        for (String item : arr) {
            for(int i = 0; i < item.length(); i++){
                if(i == 0){
                    temp = Long.parseLong(item.charAt(i) + "") * Long.parseLong(item.charAt(i + 1) + "");
                    
                    i = i + 1;
                }
                else{
                    
                    temp = temp * Long.parseLong(item.charAt(i) + "");
                }
            }
            if(largestProduct < temp)
                largestProduct = temp;
            temp = 0;
        }
        
        return largestProduct;
    }
    
    public ArrayList getArrayDigits() throws Exception {
        
        if(this.nDefined){
            //Realizar proceso
            String n = Long.toString(this.n);
            int cont = 0;
            String temp = "";
            ArrayList arr = new ArrayList();
           
            
            for(int i = 0; i < n.length(); i++){
                temp = temp + n.charAt(i);
                
                if( i == (this.k - 1) + cont){
                    
                    if(temp.length() == this.k )
                        arr.add(temp);
                    
                    cont++;
                    i = cont - 1;
                    temp = "";
                }
            }
            
            
            return arr;
        }else{
            
            throw new Exception("El número entero de " + this.nDig + " dígitos no está definido");
            
        }
        
        
    }
}
