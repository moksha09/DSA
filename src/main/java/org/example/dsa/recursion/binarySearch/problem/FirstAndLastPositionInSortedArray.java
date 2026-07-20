package org.example.dsa.recursion.binarySearch.problem;

import java.util.Arrays;

public class FirstAndLastPositionInSortedArray {
    public int[] searchRange(int[] nums, int target){
        int[] result = new int[2];
        int n = nums.length;
        result[0] = binarySearch(nums, target, true);
        result[1] = binarySearch(nums, target, false);

        return result;
    }

    public int binarySearch(int[] nums, int target, boolean isLeft){
        int start = 0;
        int end = nums.length-1;
        int idx = -1;

        while(start<end){
            int middle = (start+end)/2;
            if(nums[middle]==target){
                // search the left side to get the start and then the right side of array to find the end
                idx = middle;
                if(isLeft){
                    end = middle-1;
                }else{
                    start = middle+1;
                }
            }
            if(nums[middle]<target){
                start = middle+1;
            }
            if(nums[middle]>target){
                end = middle-1;
            }
        }
        return idx;
    }
}
