package org.example.sorting.problems.assignment.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays349 {
    public static void main(String[] args){

    }

    // 1) My approach - using sets

    /**
     * Time complexity:
     * O(n + m)
     * Space complexity:
     * O(n + m)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        // convert into sets to remove duplicates
        for(int num1: nums1){
            set1.add(num1);
        }
        for(int num2: nums2){
            if(set1.contains(num2)){
                result.add(num2);
            }
        }

        // copy the array -
        int[] output = new int[result.size()];
        int i=0;
        for(int num : result){
            output[i] = num;
            i++;
        }
        return output;
    }

    // 2 nd approach - sorting and then using a 2 pointer -

    /**
     * Complexity
     *
     * Time: O(n log n + m log m) for sorting + O(n + m) for the two-pointer scan → overall O(n log n + m log m).
     * Space: O(1) extra (not counting output), plus O(k) for result where k = size of intersection.
     * After sorting, equal values line up. By walking both arrays once, you find every common value in O(n + m) time (after the sorts).
     * Sorting costs O(n log n + m log m), but you avoid extra hash-set storage.
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2){
        // sort the 2 arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();

        // using 2 pointer -
        int i=0;
        int j=0;
        Integer lastAdded = null;
        while (i< nums1.length && j< nums2.length){
            if(nums1[i] == nums2[j]){
                if(lastAdded == null || lastAdded != nums1[i]){
                    result.add(nums1[i]);
                    lastAdded = nums1[i];
                }
                i++;
                j++;
            } else if(nums1[i] > nums2[j]){
                j++;
            } else{
                i++;
            }
        }

        int[] output = new int[result.size()];
        for(int k=0; k<result.size();k++){
            output[k] = result.get(k);
        }
        return output;
    }

}
