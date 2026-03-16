package org.example.recursion.assignment.easy;

public class BinarySearchUsingRecursion {

    /**
     * Given an array of integers nums which is sorted in ascending order,
     * and an integer target, write a function to search target in nums.
     * If target exists, then return its index. Otherwise, return -1.
     *
     * You must write an algorithm with O(log n) runtime complexity.
     */

    static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }

    static int binarySearch(int[] nums, int start, int end, int target){
        // base condition -
        if(start>end){
            return -1;
        }
        int middle = (start+end)/2;

        if(nums[middle] == target){
            return middle;
        }else if(target>nums[middle]){
            return binarySearch(nums, middle+1, end, target);
        }else{
            return binarySearch(nums, start, middle-1, target);
        }
    }
    public static void main(String[] args){

    }
}
