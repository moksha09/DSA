package org.example.dsa.sorting.problems.assignment.easy;

import java.util.Arrays;

public class SortArrayByParityI905 {

    /**
     * Given an integer array nums, move all the even integers at
     * the beginning of the array followed by all the odd integers.
     * Return any array that satisfies this condition.
     * @param nums
     * @return
     */

    // 1) My approach - use two pointer
    static int[] sortArrayByParity(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            while(start<=end && nums[start]%2==0){
                start++;
            }

            while(start<=end && nums[end]%2!=0){
                end--;
            }

            if(start<=end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }

        }
        return nums;
    }
    public static void main(String[] args){
        int[] arr = {0};
        System.out.println(Arrays.toString(sortArrayByParity(arr)));
    }
}
