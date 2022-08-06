package anagramremoveletters;

import java.util.HashMap;
import java.util.Map;

public class AnagramRemoveLetters {

    public static void main(String[] args) {
        NumebrOfRemovedLetters("legs", "glue");
    }

    private static void NumebrOfRemovedLetters(String a, String b) {
        Map<Character, Integer> map = new HashMap<>();

        String Letters = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 26; i++) {
            map.put(Letters.charAt(i), 0);
        }

        for (int i = 0; i < a.length(); i++) {
            map.put(a.charAt(i), map.get(a.charAt(i)) + 1);
        }

        for (int i = 0; i < b.length(); i++) {
            map.put(b.charAt(i), map.get(b.charAt(i)) - 1);
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += Math.abs(map.get(Letters.charAt(i)));
        }
        System.out.println(count);
    }

}
