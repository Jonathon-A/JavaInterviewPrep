package slidingwindow;

import java.util.Arrays;

public class SlidingWindow {

    public static void main(String[] args) {
        System.out.println("Largest substring that is a palandrome: " + StringWindow());
    }
    
    private static void ArrayWindow(){
      String[] Array = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};

        for (int k = Array.length; k > 0; k--) {

            System.out.println("K: " + k);
            for (int i = 0; i <= Array.length - k; i++) {

                System.out.println(Arrays.toString(Arrays.copyOfRange(Array, i, i + k)));
            }
        }
    }

    private static String StringWindow(){
      String str = "abcdefedcbaa";

        for (int k = str.length(); k > 0; k--) {

            System.out.println("K: " + k);
            for (int i = 0; i <= str.length() - k; i++) {
                String check = str.substring(i,i+k);
                if (CheckPalandrome(check)) {
                    
                    return check;
                }
                
            }
        }
        
         return "-1";
    }
    
    private static boolean CheckPalandrome(String str){
        for (int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
            return false;
            }
        }
        return true;
    }
}
