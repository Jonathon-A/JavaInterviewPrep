/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decimaltobinary;

/**
 *
 * @author Student
 */
public class DecimalToBinary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
        System.out.println(toBinary(24,""));
    }
    
    private static String toBinary(int n, String Result){
    
        
        if(n == 0){
        return Result;
        }
        return toBinary(n/2,n%2 + Result);
    }
    
}
