package cansum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CanSum {

    public static void main(String[] args) {

        int[] arr = {2,3,5,10};
        map = new HashMap<>();
        System.out.println(CanSum(3001, arr));
        memo = new HashMap<>();
        System.out.println(howSum(20, arr));
        memo = new HashMap<>();
        System.out.println(bestSum(50,arr));
    }
    private static Map<Integer, Boolean> map = new HashMap<>();

    private static boolean CanSum(int target, int[] arr) {

        if (map.get(target) != null) {
            return map.get(target);
        }

        boolean[] results = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {

            int sum = target - arr[i];
            if (sum < 0) {

                results[i] = false;
            } else if (sum == 0) {
                results[i] = true;
            } else {
                results[i] = CanSum(sum, arr);
            }
        }

        for (int i = 0; i < results.length; i++) {

            if (results[i]) {
                map.put(target, true);
                return true;
            }
        }
        map.put(target, false);
        return false;
    }

    private static Map<Integer, ArrayList<Integer>> memo = new HashMap<>();

    private static ArrayList<Integer> howSum(int target, int[] arr) {

        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        if (target == 0) {
            return new ArrayList<>();
        }

        if (target < 0) {
            return null;
        }

        for (int i = 0; i < arr.length; i++) {
            int sum = target - arr[i];
            ArrayList<Integer> result = howSum(sum, arr);
            if (result != null) {
                result.add(arr[i]);
                memo.put(target, result);
                return result;
            }
        }
        memo.put(target, null);
        return null;
    }

     private static Map<Integer, ArrayList<Integer>> memo2 = new HashMap<>();
    
    private static ArrayList<Integer> bestSum(int target, int[] arr) {
        if (memo2.containsKey(target)) {
            return memo2.get(target);
        }

        if (target == 0) {
            return new ArrayList<>();
        }

        if (target < 0) {
            return null;
        }
        ArrayList<Integer> ShortestResult = null;
        int ShortestSize = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = target - arr[i];
            ArrayList<Integer> result = bestSum(sum, arr);
            if (result != null) {
                result.add(arr[i]);
                if (result.size() < ShortestSize) {
                    ShortestSize = result.size();
                    ShortestResult = result;
                }
                
            }
        }
        //memo2.put(target, ShortestResult);
       
        return ShortestResult;
    }

}
