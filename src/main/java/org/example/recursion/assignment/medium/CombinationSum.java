package org.example.recursion.assignment.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    /**
     * Given an array of distinct integers candidates and a target integer target,
     * return a list of all unique combinations of candidates where the chosen numbers sum to target.
     * You may return the combinations in any order.
     * The same number may be chosen from candidates an unlimited number of times.
     * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
     * The test cases are generated such that the number of unique combinations that sum up to target
     * is less than 150 combinations for the given input.
     *
     * Example 1:
     *
     * Input: candidates = [2,3,6,7], target = 7
     * Output: [[2,2,3],[7]]
     * Explanation:
     * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
     * 7 is a candidate, and 7 = 7.
     * These are the only two combinations.
     * @param candidates
     * @param target
     * @return
     */

    // [2,3,5] ->8
    static List<List<Integer>> combinationSum(int[] candidates, int target){
        Arrays.sort(candidates);
        return combinationSumHelper(candidates, target, 0, new ArrayList<>());
    }
    static List<List<Integer>> combinationSumHelper(int[] candidates, int target, int index, List<Integer> current) {
        // if target is zero print the current combination
        if(target==0){
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>(current));
            return list;
        }
        // when index reaches the end stop -
        if(index == candidates.length){
            return new ArrayList<>();
        }
        int currentElement= candidates[index];
        // skip/break
        if(currentElement>target){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        // take the current element -
        current.add(currentElement);
        result.addAll(combinationSumHelper(candidates, target-currentElement, index, current));
        current.remove(current.size()-1);

        // skip the current element
        result.addAll(combinationSumHelper(candidates, target, index+1, current));

        return result;

    }
    public static void main(String[] args){
        int[] candidates = new int[] {8, 7, 4, 3};
        System.out.println(combinationSum(candidates, 11));
    }
}