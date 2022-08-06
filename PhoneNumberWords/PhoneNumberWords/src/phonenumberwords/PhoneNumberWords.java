package phonenumberwords;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumberWords {

    public static void main(String[] args) {
           String[] a = new String[] {"a"};
            map.put("a", "2");
            map.put("b", "2");
            map.put("c", "2");
            map.put("d", "3");
            map.put("e", "3");
            map.put("f", "3");
            map.put("g", "4");
            map.put("h", "4");
            map.put("i", "4");
            map.put("j", "5");
            map.put("k", "5");
            map.put("l", "5");
            map.put("m", "6");
            map.put("n", "6");
            map.put("o", "6");
            map.put("p", "7");
            map.put("q", "7");
            map.put("r", "7");
            map.put("s", "7");
            map.put("t", "8");
            map.put("u", "8");
            map.put("v", "8");
            map.put("w", "9");
            map.put("x", "9");
            map.put("y", "9");
            map.put("z", "9");
        
        String[] Words = {"foo", "bar", "baz", "foobar", "emo", "cap", "car", "cat"};

        String[] ReturnedWords = CheckPhoneNumberForWord("3662277", Words);
        Arrays.sort(ReturnedWords);
        for (int i = 0; i < ReturnedWords.length; i++) {
            System.out.print(ReturnedWords[i] + ", ");
        }

    }

    private static String[] CheckPhoneNumberForWord(String PhoneNumber, String[] Words) {
        String str = "";
        for (int i = 0; i < Words.length; i++) {
            String Num = Convert(Words[i]);
            int Length = Num.length();
            for (int j = 0; j < PhoneNumber.length() - Length; j++) {
                if (PhoneNumber.substring(j, j + Length).equals(Num)) {
                    str += Words[i] + " ";
                }
            }
        }
        return str.split(" ");
    }

    private static Map<String, String> map = new HashMap<>();

           
    
    private static String Convert(String Word) {

        
   

        String Nums = "";

        for (int i = 0; i < Word.length(); i++) {

           // if (map.get(Word.substring(i, i + 1)) != null) {
                Nums += map.get(Word.substring(i, i + 1));
                
           // }

        }
        return Nums;
    }

}
