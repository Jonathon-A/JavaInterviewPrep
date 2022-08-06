package validanagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(IsAnagram("garden", "danger"));
        System.out.println(IsAnagram("garden", "danger"));
        
        System.out.println(IsLexicographicallyAnagram("garden", "boopop"));
        System.out.println(IsLexicographicallyAnagram("nameless", "salesmen"));
    }

    //O(n)
    //O(n)
    
    private static boolean IsAnagram(String word, String sub) {
        //false if different length
        if (word.length() != sub.length()) {
            return false;

        }

        Map<Character, Integer> map = new HashMap<>();
        //map that counts chars in word (+1)
        for (int i = 0; i < word.length(); i++) {
            if (map.containsKey(word.charAt(i))) {
                map.put(word.charAt(i), map.get(word.charAt(i)) + 1);
            } else {
                map.put(word.charAt(i), 1);

            }

        }
        //map that counts chars in sub (-1)
        for (int i = 0; i < sub.length(); i++) {
            if (map.containsKey(sub.charAt(i))) {
                map.put(sub.charAt(i), map.get(sub.charAt(i)) - 1);
                
            } //if not in map then false
            else {
                return false;

            }

        }
        //if map not zero then false;
        for (int i = 0; i < word.length(); i++) {
            if (map.get(word.charAt(i)) != 0) {
                return false;
            }
        }

        return true;

    }
    
    //O(n log n)
    //O(n)
    
    private static boolean IsLexicographicallyAnagram(String word, String sub){
        //false if different length
        if (word.length() != sub.length()) {
            return false;

        }
        
        char[] wordChars = word.toCharArray();
        Arrays.sort(wordChars);
        char[] subChars = sub.toCharArray();
        Arrays.sort(subChars);
       
        return (new String(wordChars).equals(new String(subChars)));
    }

}
