/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetfirstandlastposition;

/**
 *
 * @author Student
 */
public class TargetFirstAndLastPosition {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] nums = {2, 4, 5, 5, 5, 5, 6, 6, 7, 8};
        int target = 5;
        int[] FirstAndLast;

        if (nums == null || nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) {
            FirstAndLast = new int[]{-1, -1};
        } else {
            FirstAndLast = new int[]{findFirst(nums, target), findSecond(nums, target)};
        }

        System.out.println(FirstAndLast[0] + " " + FirstAndLast[1]);
    }

    //O(n log n)
    //O(1)
    
    private static int findFirst(int[] nums, int target) {
        if (nums[0] == target) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target && nums[mid - 1] < target) {
                return mid;
            }

            if (target > nums[mid]) {
                left = mid + 1;

            } else {
                right = mid - 1;
            }

        }

        return -1;
    }

    private static int findSecond(int[] nums, int target) {
        if (nums[nums.length - 1] == target) {
            return nums.length - 1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target && nums[mid + 1] > target) {
                return mid;
            }

            if (target < nums[mid]) {

                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return -1;
    }

}
