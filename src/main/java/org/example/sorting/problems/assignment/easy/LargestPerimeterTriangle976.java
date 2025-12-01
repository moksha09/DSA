package org.example.sorting.problems.assignment.easy;

public class LargestPerimeterTriangle976 {

    /**
     * Given an integer array nums, return the largest perimeter of a triangle
     * with a non-zero area, formed from three of these lengths.
     * If it is impossible to form any triangle of a non-zero area, return 0.
     * @param nums
     * @return
     */

    // MY APPROACH -
    //1) SOrt the arrays
    //2) check is the sum of consecutive numbers starting from start is greater than
    // the next number is yes take that perimeter for triangle else move forward

    public int largestPerimeter(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        int largetPerimeter = 0;
        int n= nums.length;
        if(n>=3){
            for(int i=0; i<=n-3;i++){
                if(nums[i]+nums[i+1]>nums[i+2]){
                    largetPerimeter = nums[i]+nums[i+1]+nums[i+2];
                }
            }
        }
        return largetPerimeter;
    }

    // Using quicksort of different implementation - taking last element as pivot -
    private void quickSort(int[] nums, int low , int high){
        if(low>=high) return;

        int pivotIndex = partition(nums, low, high);

        quickSort(nums,low,pivotIndex-1);
        quickSort(nums,pivotIndex+1, high);
    }

    private int partition(int[] nums, int low, int high){
        int pivot = nums[high];
        int i=low;

        for(int j=0; j<high; j++){
            if(nums[j]<=pivot){
                // swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
            }
        }
        // putting pivot element in correct position -
        int temp = nums[i];
        nums[i] = nums[high];
        nums[high] = temp;

        return i; // returning the correct pivot position

    }

    public static void main(String[] args){

    }
}
