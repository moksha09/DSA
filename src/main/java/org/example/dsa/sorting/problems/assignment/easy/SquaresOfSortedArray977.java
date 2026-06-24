package org.example.dsa.sorting.problems.assignment.easy;

import java.util.Arrays;

public class SquaresOfSortedArray977 {

    /**
     * Given an integer array nums sorted in non-decreasing order,
     * return an array of the squares of each number sorted in non-decreasing order.
     *
     * Example 1:
     * Input: nums = [-4,-1,0,3,10]
     * Output: [0,1,9,16,100]
     * Explanation: After squaring, the array becomes [16,1,0,9,100].
     * After sorting, it becomes [0,1,9,16,100].
     *
     * Example 2:
     * Input: nums = [-7,-3,2,3,11]
     * Output: [4,9,9,49,121]
     *
     * Constraints:
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums is sorted in non-decreasing order.
     *
     * Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
     */

    //  MY APPROACH -
    // 1) Squaring each number and sorting array

    static int[] sortedSquares(int[] nums){
        for(int i=0; i<nums.length; i++){
            nums[i] = nums[i]*nums[i];
        }

        Arrays.sort(nums);
        return nums;
    }

    //2) - Optimized approach - do it in O(n) - Using two pointer
    static int[] sortedSquares2(int[] nums){
        int n = nums.length;
        int[] result = new int[n];

        int start = 0;
        int end = n-1;
        int pos = n-1;

        while(start<=end){
            int leftAbs = Math.abs(nums[start]);
            int rightAbs = Math.abs(nums[end]);

            if(leftAbs > rightAbs){
                result[pos] = leftAbs*leftAbs;
                start++;
            }else {
                result[pos] = rightAbs*rightAbs;
                end--;
            }
            pos--;
        }

        return result;

    }



    public static void main(String[] args){

    }
}
