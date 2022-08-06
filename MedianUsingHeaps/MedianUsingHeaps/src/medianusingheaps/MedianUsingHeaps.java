/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medianusingheaps;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * @author Student
 */
public class MedianUsingHeaps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        highers = new PriorityQueue<>();
        lowers = new PriorityQueue<>(Collections.reverseOrder());

        int[] nums = {1, 2, 3, 4, 5};

        for (int i = 0; i < nums.length; i++) {
            AddNum(nums[i]);

            System.out.println(GetMedian());
        }
        System.out.println(highers.poll());
        System.out.println(highers.poll());
    }

    static PriorityQueue<Integer> highers = new PriorityQueue<>();
    static PriorityQueue<Integer> lowers = new PriorityQueue<>(Collections.reverseOrder());

    private static double GetMedian() {
        
        //get peek of bigger heap
        //if both same size, get average of both heaps
        if (highers.size() > lowers.size()) {
            return (highers.peek());
        } else if (highers.size() < lowers.size()) {
            return (lowers.peek());
        } else {
            return (((double) highers.peek() + (double) lowers.peek()) / 2);
        }
    }

    private static void AddNum(int num) {
        //add num to lower heap if num less than biggest value in lower heap
        if (lowers.isEmpty() || num < lowers.peek()) {
            lowers.add(num);
        } else {
            highers.add(num);
        }
        
        //rebalence
        //if difference is bigger than 1, take element from bigger heap and give to smaller heap
        if (Math.abs(lowers.size() - highers.size()) > 1) {

            if (highers.size() > lowers.size()) {
                lowers.add(highers.poll());
            } else {
                highers.add(lowers.poll());
            }

        }
    }

    private static void RemoveNum(int num) {
        if (lowers.contains(num)) {
            lowers.remove(num);
        } else {
            highers.remove(num);
        }
        //rebalence
        if (Math.abs(lowers.size() - highers.size()) > 1) {

            if (highers.size() > lowers.size()) {
                lowers.add(highers.poll());
            } else {
                highers.add(lowers.poll());
            }

        }
    }

}
