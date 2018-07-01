/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largestproduct;

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
    }
    
    public Calculating(int k, int nDig){
        this.k = k;
        this.nDig = nDig;
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
            
            throw new Exception("El número ingresado no comple con el número de dígitos establecido No. Dígitos: " + this.nDig);
            
        }else{
            
            this.n = n;
            this.nDefined = true;
            
        }
        
    }
    
    public long getLargestProduct() throws Exception {
        
        if(this.nDefined){
            //Realizar proceso
            String n = Long.toString(this.k);
            long largesProduct = -10000000000000l;
            
            
            
            for(int i = 0; i < n.length(); i++){
                
                System.out.print(n.charAt(i));
                
                
                if(i == this.k - 1){
                    System.out.println();
                    
                    i = this.k - i;
                }
                    
                
            }
            
            
            
        }else{
            throw new Exception("El número entero de " + this.nDig + " dígitos no está definido");
        }
        
        
        return this.nDig;
    }
}
