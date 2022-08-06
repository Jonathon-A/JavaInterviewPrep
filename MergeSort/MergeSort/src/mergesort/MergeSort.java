/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.util.Arrays;

/**
 *
 * @author Student
 */
public class MergeSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 5, 6, 8, 5, 4, 7, 8};
        MergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void MergeSort(int[] arr, int low, int high) {

        if (low < high) {
            int mid = low + (high - low) / 2;
            MergeSort(arr, low, mid);
            MergeSort(arr, mid + 1, high);
            Merge(arr, low, mid, high);

        }

    }

    private static void Merge(int[] arr, int low, int mid, int high) {

        int left = low;
        int right = mid + 1;

        int index = 0;

        int[] temp = new int[high - low + 1];

        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                temp[index] = arr[left];
                left++;
                index++;

            } else {
                temp[index] = arr[right];
                right++;
                index++;

            }

        }

        while (left <= mid) {
            temp[index] = arr[left];
            left++;
            index++;
        }

        while (right <= high) {
            temp[index] = arr[right];
            right++;
            index++;
        }

        System.arraycopy(temp, 0, arr, low, temp.length);

    }

}
