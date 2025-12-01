package org.example.sorting.problems.assignment.easy;

import java.util.Arrays;

public class MaxProductOfTwoElementsInArray1464 {

    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n-1]-1)*(nums[n-2]-1);

    }


    public static void main(String[] args){

    }
}
