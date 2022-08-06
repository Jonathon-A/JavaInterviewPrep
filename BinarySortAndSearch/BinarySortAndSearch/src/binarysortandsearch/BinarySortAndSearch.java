package binarysortandsearch;

import java.util.ArrayList;




public class BinarySortAndSearch {

    public static void main(String[] args) {
        int[] arr = {37, 23, 0, 17, 12, 72, 31, 46, 100, 88, 54};

        ArrayList<Integer> SortedArray = new ArrayList<>();

        SortedArray.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            SortedArray.add(BinarySearchIndex(SortedArray, arr[i], 0, SortedArray.size() - 1), arr[i]);

        }

        System.out.println(SortedArray);

        System.out.println(BinarySearch(SortedArray, 31, 0, arr.length));
    }

    private static int BinarySearch(ArrayList<Integer> arr, int value, int low, int high) {

        while (low <= high) {

            int mid = low + (high - low) / 2;
            if (arr.get(mid) == value) {
                return mid;
            }
            if (arr.get(mid) > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;

    }

    private static int BinarySearchIndex(ArrayList<Integer> SortedArray, int value, int low, int high) {
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (value == SortedArray.get(mid)) {
                return mid + 1;
            } else if (value > SortedArray.get(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

}
