package canconstruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CanConstruct {

    public static void main(String[] args) {
        memory = new HashMap<>();
        String[] words = {"abcd", "abc", "def","ef","e","f"};
        TargetWord = "abcdef";
        System.out.println(CanConstruct("", words));
        memory2= new HashMap<>();
        System.out.println(CountConstruct("", words));
        
        System.out.println(AllConstruct("", words));
        memory = new HashMap<>();
        words = new String[]{"bo", "rd", "ate", "cd", "t", "ska","sk","boar"};
        TargetWord = "skateboard";
        System.out.println(CanConstruct("", words));
        memory2= new HashMap<>();
        System.out.println(CountConstruct("", words));
        
        System.out.println(AllConstruct("", words));
    }

    private static String TargetWord;

    private static Map<String, Boolean> memory = new HashMap<>();

    private static boolean CanConstruct(String word, String[] bank) {

        if (memory.containsKey(word)) {
            return memory.get(word);
        }

        if (word.length() > TargetWord.length()) {
            return false;
        }
        if (!word.substring(0, word.length()).equals(TargetWord.substring(0, word.length()))) {
            return false;
        }
        if (word.equals(TargetWord)) {
            return true;
        }

        boolean[] ConstructionFound = new boolean[bank.length];

        for (int i = 0; i < bank.length; i++) {
            ConstructionFound[i] = CanConstruct(word + bank[i], bank);
        }

        for (int i = 0; i < ConstructionFound.length; i++) {
            if (ConstructionFound[i]) {
                memory.put(word, true);
                return true;
            }
        }
        memory.put(word, false);
        return false;

    }
    
     private static Map<String, Integer> memory2= new HashMap<>();
    
     private static int CountConstruct(String word, String[] bank) {
         
         if(memory2.containsKey(word)){
          return memory2.get(word);
         }
         
         if (word.length() > TargetWord.length()) {
            return 0;
        }
        if (!word.substring(0, word.length()).equals(TargetWord.substring(0, word.length()))) {
            return 0;
        }
        if (word.equals(TargetWord)) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < bank.length; i++) {
             count += CountConstruct(word + bank[i], bank);
        }
        memory2.put(word,count);
        return count;
    }
     
     private static ArrayList<ArrayList<String>> AllConstruct(String word, String[] bank){
         
         
         if(word.length() > TargetWord.length()){
             return null;
         }
         
         if (!word.substring(0, word.length()).equals(TargetWord.substring(0, word.length()))) {
            return null;
        }
        if(word.equals(TargetWord)){
            ArrayList<ArrayList<String>> temp = new ArrayList<>();
            temp.add(new ArrayList<>());
             return  temp;
         }
          ArrayList<ArrayList<String>> FinalResult = new ArrayList<>();
         for (int i = 0; i < bank.length; i++) {
             ArrayList<ArrayList<String>> result = AllConstruct(word + bank[i], bank);
            //  System.out.println(word +  " "+ result);
             if(result != null){
                // System.out.println("yes");
                 for (int j = 0; j < result.size(); j++) {
                    
                     result.get(j).add(bank[i]);
                  //   System.out.println(result.get(j));
                     FinalResult.add(result.get(j));
                 }
                // System.out.println(FinalResult);
                 
             }
         }
        // System.out.println(FinalResult);
         if(FinalResult.isEmpty()){
          return null;
         }
         return FinalResult;
     }
    
    

}
