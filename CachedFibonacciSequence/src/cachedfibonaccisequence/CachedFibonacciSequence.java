package cachedfibonaccisequence;

import java.util.*;

public class CachedFibonacciSequence {

    public static void main(String[] args) {
        System.out.println(FibonacciSequence(10));
        System.out.println(FibonacciSequence(40));
        System.out.println(FibonacciSequence(20));
        System.out.println(FibonacciSequence(31));
        System.out.println(FibonacciSequence(20));
        System.out.println(FibonacciSequence(40));
        System.out.println(FibonacciSequence(31));
        System.out.println(FibonacciSequence(4));
         System.out.println(FibonacciSequence(45));
        
        System.out.println("");
        
        System.out.println(FibonacciSequenceTabulation(1));
         System.out.println(FibonacciSequenceTabulation(2));
          System.out.println(FibonacciSequenceTabulation(6));
           System.out.println(FibonacciSequenceTabulation(40));
           System.out.println(FibonacciSequenceTabulation(45));
    }

    private static Map<Integer, Integer> map = new HashMap<>();

    private static int FibonacciSequence(int n) {
        if (n <= 2) {
            return 1;
        }
        

        int a;
        if(map.containsKey(n-1)){
            a = map.get(n-1);
        }else{
           a  = FibonacciSequence(n - 1);
        }
        
        int b;
        if(map.containsKey(n-2)){
            b = map.get(n-2);
        }else{
           b  = FibonacciSequence(n - 2);
        }
        map.put(n, a +  b);
        return a +  b;
    }
    
    private static int FibonacciSequenceTabulation(int n) {
        
        int[] arr = new int[n + 1];
        
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 0; i <= n; i++){
            if(i + 1<= n){
            arr[i+1] += arr[i];
            }
            if(i + 2<= n){
            arr[i+2] += arr[i];
            }
        }
        return arr[n];
    }

}
