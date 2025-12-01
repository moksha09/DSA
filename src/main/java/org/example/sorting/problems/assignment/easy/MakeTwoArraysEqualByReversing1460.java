package org.example.sorting.problems.assignment.easy;

import java.util.Arrays;

public class MakeTwoArraysEqualByReversing1460 {

    /**
     * Example 1:
     *
     * Input: target = [1,2,3,4], arr = [2,4,1,3]
     * Output: true
     * Explanation: You can follow the next steps to convert arr to target:
     * 1- Reverse subarray [2,4,1], arr becomes [1,4,2,3]
     * 2- Reverse subarray [4,2], arr becomes [1,2,4,3]
     * 3- Reverse subarray [4,3], arr becomes [1,2,3,4]
     * There are multiple ways to convert arr to target, this is not the only way to do so.
     *
     * @param target
     * @param arr
     * @return
     */
    static boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return (Arrays.equals(target, arr));
    }

    public static void main(String[] args){
        int[] target = new int[]{1,2,3,4};
        int[] arr = new int[]{2,4,1,3};

        System.out.println(canBeEqual(target,arr));
    }
}
