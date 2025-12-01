package org.example.sorting.problems.assignment.easy;

import java.util.HashMap;
import java.util.Map;

public class EasySortingProblems {

    /**
     * 88. Merge Sorted Array
     * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
     * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     * The final sorted array should not be returned by the function,
     * but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n,
     * where the first m elements denote the elements that should be merged, and the last n elements are set to 0
     * and should be ignored. nums2 has a length of n.
     */

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] result = new int[nums1.length];

        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                result[k] = nums1[i];
                i++;
            }
            else{
                result[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i<m){
            result[k] = nums1[i];
            i++;
            k++;
        }

        while(j<n){
            result[k] = nums2[j];
            j++;
            k++;
        }

        for(int l = 0; l< nums1.length; l++){
            nums1[l] = result[l];
        }
    }

    /**
     * 169. Majority Element -
     * Given an array nums of size n, return the majority element.
     * The majority element is the element that appears more than ⌊n / 2⌋ times.
     * You may assume that the majority element always exists in the array.
     *
     * Example 1:
     * Input: nums = [3,2,3]
     * Output: 3
     *
     * Example 2:
     * Input: nums = [2,2,1,1,1,2,2]
     * Output: 2
     */

    // 1) MY APPROACH =
    static int majorityElement(int[] nums) {
        // first lets sort nums
        // lets sort it using bubble sort -
        bubbleSort(nums);

//        int limit = nums.length/2;
//        for(int i=0; i<nums.length-limit; i++){
//            if(nums[i+limit] == nums[i]){
//                return nums[i];
//            }
//        }
        /**
         * You dont need to check each index to see if its === arr[i+n./2]
         * After sorting the majority element should be present at - arr[n/2];
         */
        return nums[nums.length/2];

    }
    private static void bubbleSort(int[] arr)
    {
        boolean isSwapped = false;
        // Loop for each pass -
        for(int i=0; i<arr.length; i++){
            // loop for checking and swapping elements
            for(int j=1; j< arr.length-i; j++){
                if(arr[j]<arr[j-1]){
                    // swap
                    int temp  = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    isSwapped = true;
                }
            }
            // when you didn't even once for a particular value of i then that means the array is already sorted
            if(!isSwapped) break;
        }
    }

    // 2) Boyer- Moore Voting Algorithm - ggod when you knwo for sure there exists a majority element
    static int majorityElement2(int[] nums) {
        int majorityElem = nums[0];
        int count = 0;

        for(int num : nums){
            if(count == 0){
                majorityElem = num;
                count = 1;
            } else if(num == majorityElem){
                count++;
            } else{
                count--;
            }
        }
        return majorityElem;
    }

    // 3) - Using Hashmap - when majority element might or moght not exist -
    static int majorityElement3(int[] nums) {
        //  1. Create a HashMap
        Map<Integer, Integer> frequency = new HashMap<>();

        //2. Loop through array-
//        For each number:
//          - increase its count in the map
//          - check if it crossed n/2
//          - if yes → immediately return
        for(int num: nums){
            int count = frequency.getOrDefault(num,0) + 1;
            frequency.put(num, count);

            if(count>nums.length/2){
                return num;
            }
        }
        return -1;
    }


    public static void main(String[] args){
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement2(nums));

    }
}
