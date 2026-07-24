package org.example.dsa.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationOfArray {
    // LC - 46 ( MEDIUM ) -
    // Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

    // Approach1 - swapping - here we are modifying the nums array itself for different permutations
    // and once we get a result we are backtracking it

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, result);
        return result;
    }

    public void helper(int[] nums, int start, List<List<Integer>> result){
        // base case -
        if(start == nums.length){
            List<Integer> currentPerm = new ArrayList<>();
            for(int num : nums){
                currentPerm.add(num);
            }
            result.add(currentPerm);
        }

        for(int i=start; i<nums.length; i++){
            // swap
            swap(nums, start, i);
            helper(nums, start+1, result); // get the result

            // backtrack - swap it back to get the original nums -
            swap(nums, start, i);
        }
    }

    public void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }




}
