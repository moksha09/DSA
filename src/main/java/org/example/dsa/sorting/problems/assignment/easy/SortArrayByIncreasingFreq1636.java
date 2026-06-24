package org.example.dsa.sorting.problems.assignment.easy;

// LEARN HOW TO USE COMPARATOR
public class SortArrayByIncreasingFreq1636 {

    /**
     * Given an array of integers nums,
     * sort the array in increasing order based on the frequency of the values.
     * If multiple values have the same frequency, sort them in decreasing order.
     * Return the sorted array.
     *
     * Example 1:
     * Input: nums = [1,1,2,2,2,3]
     * Output: [3,1,1,2,2,2]
     * Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
     *
     * Example 2:
     * Input: nums = [2,3,1,3,2]
     * Output: [1,3,3,2,2]
     * Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
     *
     * [2,3,1,3,2] ->{ {2:2}, {3:2}, {1:1} }  --> [1,2,2,3,3]
     *
     * @param nums
     * @return
     */
    // BRUTE FORCE -
    static int[] frequencySort(int[] nums) {
        return null;

    }

    public static void main(String[] arg){
        int[] nums = {2,3,1,3,2};
        frequencySort(nums);

    }
}
