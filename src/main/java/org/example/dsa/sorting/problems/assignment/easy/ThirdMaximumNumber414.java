package org.example.dsa.sorting.problems.assignment.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThirdMaximumNumber414 {

    /**
     * Third maximum number - easy 414
     * Given an integer array nums, return the third distinct maximum number in this array.
     * If the third maximum does not exist, return the maximum number.
     *
     * Example 1:
     * Input: nums = [3,2,1]
     * Output: 1
     * Explanation:
     * The first distinct maximum is 3.
     * The second distinct maximum is 2.
     * The third distinct maximum is 1.
     *
     * Example 2:
     * Input: nums = [1,2]
     * Output: 2
     * Explanation:
     * The first distinct maximum is 2.
     * The second distinct maximum is 1.
     * The third distinct maximum does not exist, so the maximum (2) is returned instead.
     *
     * Example 3:
     * Input: nums = [2,2,3,1]
     * Output: 1
     * Explanation:
     * The first distinct maximum is 3.
     * The second distinct maximum is 2 (both 2's are counted together since they have the same value).
     * The third distinct maximum is 1.
     */

    // 1) - My approach -

    /**
     *  1) Remove duplicates
     *  2) Sort in ascending order
     *  3) Return the 3rd element,
     *  4) If not present return the last element.
     * @param nums
     * @return
     */
    static int thirdMax(int[] nums) {
        Set<Integer> distinctArr = new HashSet<>();

        if(nums.length==0){
            return -1;
        }

        // 1) remove duplicates
        for(int num: nums){
            distinctArr.add(num);
        }
        //2) convert it into array -
        int[] arr = new int[distinctArr.size()];
        int k=0;
        for(int a : distinctArr){
            arr[k] = a;
            k++;
        }

        Arrays.sort(arr);

        if(arr.length>=3){
            return arr[arr.length-3];
        } else {
            return arr[arr.length-1];
        }
    }

    // Approach 2 - Calculate firstMax, secondMax, thirdMax -


    public static void main(String[] args){
        int[] nums = {1,2,3};
        System.out.println(thirdMax(nums));


    }
}
