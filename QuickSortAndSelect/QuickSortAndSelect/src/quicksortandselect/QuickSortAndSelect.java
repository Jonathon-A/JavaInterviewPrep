package quicksortandselect;

import java.util.Arrays;

public class QuickSortAndSelect {

    public static void main(String[] args) {
        int[] arr = {8, 7, 6, 5, 4, 3, 1};
        int[] arr2 = arr.clone();
        System.out.println(Arrays.toString(arr));
        QuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        int KthSmallest = 8;
       // System.out.println(QuickSelect(arr2, 0, arr2.length - 1, KthSmallest - 1));
    }

    private static int QuickSelect(int[] arr, int low, int high, int k) {
        if (low <= high) {
            int PartitionIndex = Partition(arr, low, high);
           
            if (k == PartitionIndex) {
                return arr[PartitionIndex];
            } else if (PartitionIndex > k) {
                return QuickSelect(arr, low, PartitionIndex - 1, k);
            } else {
                return QuickSelect(arr, PartitionIndex + 1, high, k);
            }
        }
        return -1;
    }

    private static void QuickSort(int[] arr, int low, int high) {
        if (low <= high) {
            int PartitionIndex = Partition(arr, low, high);
            //Quick sort left partition
            QuickSort(arr, low, PartitionIndex - 1);
            //Quick sort right partition
            QuickSort(arr, PartitionIndex + 1, high);
        }
    }

    private static int Partition(int[] arr, int low, int high) {
        //pivot = right most index of arr
        int pivot = arr[high];
        int i = low - 1;
        //swap elements lesser than pivot element to right of pivot element
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                Swap(arr, i, j);
            }
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(arr[i + 1] + " new " + arr[high]);
        Swap(arr, i + 1, high);
        System.out.println(Arrays.toString(arr));
        //return pivots index
        return i + 1;
    }

    private static void Swap(int[] arr, int i, int j) {
        //swaps two elements in array
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
    }
}
