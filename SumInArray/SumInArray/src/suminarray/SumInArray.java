package suminarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumInArray {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6};
        ArrayList<int[]> pairs = FindPair(arr, 6);

        for (int i = 0; i < pairs.size(); i++) {
            System.out.println(Arrays.toString(pairs.get(i)));
        }
    }

    private static ArrayList<int[]> FindPair(int[] arr, int target) {
        ArrayList<int[]> pairs = new ArrayList<>();
        Map<Integer, Integer> table = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            table.put(arr[i], i);
            if (table.get(target - arr[i]) != null) {
                int[] pair = new int[2];
                pair[0] = i;
                pair[1] = table.get(target - arr[i]);
                pairs.add(pair);
            }

        }
        return pairs;
    }
}
