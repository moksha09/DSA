package org.example.sorting.problems.assignment.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII350 {
    public static void main(String[] args){

    }

    // This time let use hashmap rather than sorting(sone in intersection-1)
    static int[] intersect(int[] nums1, int[] nums2){
        Map<Integer, Integer> counter = new HashMap<>();

        // Get count of each element from nums1 array -
        for(int num1: nums1){
            int count = counter.getOrDefault(num1,0)+1;
            counter.put(num1, count);
        }

        List<Integer> result = new ArrayList<>();

        // check if nums2 element is present in nums2, if yes add it to result and reduce the count
        for(int num2: nums2){
            if(counter.getOrDefault(num2,0) > 0){
                result.add(num2);
                counter.put(num2, counter.get(num2)-1);
            }
        }

        // copy result
        int[] output = new int[result.size()];
        for(int k=0; k<result.size(); k++){
            output[k] = result.get(k);
        }

        return output;
    }
}
