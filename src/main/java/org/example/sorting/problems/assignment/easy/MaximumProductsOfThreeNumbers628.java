package org.example.sorting.problems.assignment.easy;

import java.util.Arrays;

public class MaximumProductsOfThreeNumbers628 {
    /**
     Given an integer array nums, find three numbers whose product is maximum
     and return the maximum product.
     Eg -
     * nums = [-100,-98,-1,2,3,4]
     * output = 39200 = -100 x -98 x 4
     */

    //1) My approach - Lets divide the array into positive and negatives -
    //2) If the negative array contains equal or more than 2 numbers,
    // multiply them with (-1) and add it to the positive arrays.
    // 3) sort the positive array and take the last 3 numbers for multplication

    static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(nums[0]*nums[1]*nums[n-1]>nums[n-3]*nums[n-2]*nums[n-1]){
            return nums[0]*nums[1]*nums[n-1];
        } else{
            return nums[n-3]*nums[n-2]*nums[n-1];
        }
    }

    public static void main(String[] args){

    }
}
