package kthlargestelement;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        int[] nums = {1, 4, 6, -7, 9, -0, -6, 4, 4};
        int k = 2;

        if (k > nums.length) {
            System.out.println("invalid");
        } else {

            for (int i = 0; i < nums.length; i++) {
                heap.add(nums[i]);
            }

            for (int i = 0; i < k - 1; i++) {
                heap.poll();
            }

            System.out.println(heap.poll());
        }
    }

}
