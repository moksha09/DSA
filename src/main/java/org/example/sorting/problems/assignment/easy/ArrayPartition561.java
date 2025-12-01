package org.example.sorting.problems.assignment.easy;

import java.util.Arrays;

public class ArrayPartition561 {

    /**
     * ARRAY PARTITION - EASY 561
     * Given an integer array nums of 2n integers, group these integers into n pairs
     * (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized.
     * Return the maximized sum.
     *
     * Example 1:
     * Input: nums = [1,4,3,2]
     * Output: 4
     * Explanation: All possible pairings (ignoring the ordering of elements) are:
     * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
     * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
     * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
     * So the maximum possible sum is 4.
     *
     * Example 2:
     * Input: nums = [6,2,6,5,1,2]
     * Output: 9
     * Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.
     *
     * Constraints:
     * 1 <= n <= 104
     * nums.length == 2 * n
     * -104 <= nums[i] <= 104
     */

    // MY APPROACH -
    // 1) sort the array
    // 2) take the sum of min of consecutive numbers.
   static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = 0;
        for(int i=0; i<=nums.length-2; i=i+2){
            maxSum = maxSum+(Math.min(nums[i],nums[i+1]));
        }
        return maxSum;
    }

    // LEETCODE - SAME APPROACH BUT RATHER THAN USING Arrays.sort() method implement quicksort and use it
    static int arrayPairSum2(int[] nums) {

       quickSort(nums, 0, nums.length);
        int maxSum = 0;
        for(int i=0; i<=nums.length-2; i=i+2){
            maxSum = maxSum+(Math.min(nums[i],nums[i+1]));
        }
        return maxSum;
    }

    private static void quickSort(int[] nums, int low, int high){
       if(low>=high) return;

       int start = low;
       int end = high;
       int middle = (start+end)/2;
       int pivot = nums[middle];

       while(start<=end){

           while(nums[start]<pivot){
               start++;
           }

           while(nums[end]>pivot){
               end--;
           }

           if(start<=end){
               // swap
               int temp = nums[start];
               nums[start] = nums[end];
               nums[end] = temp;

               start++;
               end--;
           }
       }

       quickSort(nums,low,end);
       quickSort(nums,start,high);
    }


    public static void main(String[] args){
        int[] nums = {1,4,3,2};
        System.out.println(arrayPairSum(nums));
    }




}
