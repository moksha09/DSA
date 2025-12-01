package org.example.sorting.problems.lecture;

import java.util.ArrayList;
import java.util.List;

import static org.example.sorting.BubbleSort.swap;

public class CyclicSortProblems {
    public static void main(String[] args){
        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));

    }

    // 268. Missing number -
    /**
     * Given an array nums containing n distinct numbers in the range [0, n], n= number of elements
     * return the only number in the range that is missing from the array.
     * eg - nums = [3,0,1] , o/p = 2 -> n=3, in range 0->3, the missing number is 2
     *    - nums = [0,1], o/p = 2, -> n=2, in range 0->2, th missing number is 2
     */

    // My approach - Obviously its not using cyclic sort as I wasn't able to figure out an efficient way to use it, so instead did some maths -
    // Time Complexity is the same - O(n) , Space complexity - O(1)
    static int missingNumber(int[] arr){
        int n = arr.length;
        int total = (n*(n+1))/2;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];
        }
        return total-sum;
    }

    // Solution using cyclic sort -
    static int findMissingNumber(int[] nums) {
        // Here is sorted version of nums i will be at ith index.
        // lets ignore the index which is not in range
        int i = 0;
        int n = nums.length;
        while(i<n){
            if(nums[i] == n){
                i++;
            }
            else if (nums[i] != i) {
                swap(nums,i, nums[i]);
            } else {
                i++;
            }
        }

        for(int j=0; j<n; j++){
            if(j != nums[j]){
                return j;
            }
        }
        return n;
    }

    //-------------------------------------------------------

    // 448. Find all numbers disappeared in an array.
    /**
     * Given an array nums of n integers where nums[i] is in the range [1, n],
     * return an array of all the integers in the range [1, n] that do not appear in nums.
     * Input: nums = [4,3,2,7,8,2,3,1]
     * Output: [5,6]
     */

    static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int i = 0;
        while(i < nums.length){
            int correct = nums[i]-1;
            if(nums[correct] != nums[i]){
                swap( nums, i, correct);
            } else{
                i++;
            }
        }

        for( int j=0; j<nums.length; j++){
            if(nums[j] != j+1){
                result.add(j+1);
            }
        }
        return result;

    }

    //-------------------------------------------------------

    // 287. Find the duplicate number - Medium
    /**
     * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
     * There is only one repeated number in nums, return this repeated number.
     * You must solve the problem without modifying the array nums and using only constant extra space.
     * Input: nums = [1,3,4,2,2], n+1 = 5 -> n = 4 , range [1,4]
     * Output: 2
     *
     * Input: nums = [3,3,3,3,3], Output - 3
     */

    // The below is my approach as you can see, here I am modifying the nums array by sorting it, don't know how to do it without modifying array
    static int findDuplicate(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct = nums[i] - 1;
            if(nums[i] == nums[correct]){
                i++;
            }else{
                swap(nums, i, correct);
            }
        }
        for(int j=0; j<nums.length; j++){
            if(nums[j] != j+1){
                return nums[j];
            }
        }
        return -1;
    }

    // 442. - Find all duplicates in an array - - Medium
    /**
     * Given an integer array nums of length n where all the integers of nums are in the range [1, n]
     * and each integer appears at most twice, return an array of all the integers that appears twice
     * You must write an algorithm that runs in O(n) time and uses only constant auxiliary space,
     * excluding the space needed to store the output
     * Input: nums = [4,3,2,7,8,2,3,1]
     * Output: [2,3]
     */

    static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int i=0;
        while(i < nums.length){
            int correct = nums[i]-1;
            if(nums[i] == nums[correct]){
                i++;
            }else{
                swap(nums, i, correct);
            }
        }
        for(int j=0; j<nums.length;j++){
            if(nums[j] !=j+1){
                result.add(nums[j]);
            }
        }
        return result;
    }

    // --------------------------------------------------------------------------------
    // Set mismatch - Easy
    /**
     * You have a set of integers s, which originally contains all the numbers from 1 to n.
     * Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
     * which results in repetition of one number and loss of another number.
     * You are given an integer array nums representing the data status of this set after the error.
     * Find the number that occurs twice and the number that is missing and return them in the form of an array.
     * Input: nums = [1,2,2,4]
     * Output: [2,3]
     *
     * Input: nums = [3,2,2]
     * Output: [2,1]
     */

    static int[] findErrorNums(int[] nums) {
        int j=0;
        while(j < nums.length){
            int correct  = nums[j]-1;
            if(nums[j] == nums[correct]){
                j++;
            }else{
                swap(nums, j, correct);
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] != i+1){
                return new int[]{nums[i], i+1};
            }
        }
        return new int[]{};
    }

    // 41. First Missing Positive - Hard
    /**
     * Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
     * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
     * Input: nums = [1,2,0]
     * Output: 3
     * Explanation: The numbers in the range [1,2] are all in the array.
     */

    /*
        1) Perform cyclic sort and if the element <= 0 or element > n, skip that element for swapping.
        2) After sorting check which index has the wrong value, the result will be that index+1
     */

    static int firstMissingPositive(int[] nums) {

        int i=0;
        while(i<nums.length){
            int correct = nums[i] - 1;
            if(nums[i] <=0 || nums[i] > nums.length || nums[i] == nums[correct]){
                i++;
            }
            else{
                swap(nums, i, correct);
            }
        }

        for(int j=0; j<nums.length; j++){
            if(nums[j] != (j+1)){
                return (j+1);
            }
        }
        return nums[nums.length-1]+1;
    }

}
