package org.example.dsa;

public class BinarySearch {

    // Normal implementation -
    public int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){

            int mid = start + (end-start)/2;  // as for (s+e)/2, (s+e) can sometimes exceed the int range
            if(arr[mid] == target) return mid;
            else if(target<arr[mid]) end = mid-1;
            else start = mid+1;
        }
        return -1;
    }

    //Order Agnoitic BS - The array cn be in either ascending or descending order -

    public int orderAgnoisticBinarySearch(int[] arr, int target, int start, int end){
        int length = arr.length;
        boolean isAsc = arr[0]<arr[length-1];
        if(isAsc){
            return binarySearch(arr, target, start, end);
        }
        else {
            while(start<=end){
                int middle = start + (end-start)/2;
                if(target == arr[middle]) return middle;
                else if(target < arr[middle]) start = middle+1;
                else if (target > arr[middle]) end = middle-1;
            }
            return -1;
        }
    }

    // Lets say we dont know if the array is sorted in asc or desc order ? -order agnostic binary search

    // ceiling of a sorted array -
    public int ceiling(int[] arr, int target){

        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int middle = (start+end)/2;
            if(target == arr[middle]) return arr[middle];
            else if( target < arr[middle]) end = middle-1;
            else start = middle+1;
        }
        return arr[start];

    }

    public int floor(int[] arr, int target){

        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int middle = (start+end)/2;
            if(target == arr[middle]) return arr[middle];
            else if( target < arr[middle]) end = middle-1;
            else start = middle+1;
        }
        return arr[end];

    }

    // 744. Find Smallest Letter Greater Than Target
//    Input: letters = ["x","x","y","y"], target = "z"
//    Output: "c"
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;
        if(target>letters[-1]) return letters[0];
        while(start <= end){
            int middle = (start+end)/2;
            if(target == letters[middle]) return letters[middle+1];
            else if( target < letters[middle]) end = middle-1;
            else start = middle+1;
        }
        return letters[start];
    }

    /** Given an array of integers nums sorted in non-decreasing order,
     *  find the starting and ending position of a given target value.
     If target is not found in the array, return [-1, -1].
     You must write an algorithm with O(log n) runtime complexity.
     **/
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left  = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        result[0] = left;
        result[1] = right;
        return result;
    }
    public int binarySearch(int[] nums, int target, boolean isSearchingLeft){
        int start = 0;
        int end = nums.length-1;
        int idx = -1;
        while(start<=end){
            int middle = (start+end)/2;
            if(nums[middle] > target){
                end = middle-1;
            } else if (nums[middle] < target ) {
                start = start+1;
            }
            else {
                idx = middle;
                if(isSearchingLeft){
                    end = middle-1;
                } else {
                    start = middle+1;
                }
            }
        }
        return idx;
    }



    // Find position of element in a sorted array of inifinite number -
    public int searchElement(int[] nums, int target){
        int start = 0;
        int end = 1;
        while(start<=end){
            int middle = (start+end)/2;
            if(nums[end]<target){
                start = end;
                end = 2*end;
            }
            else if(target<nums[end]){
                if(target == nums[middle]){
                    return middle;
                }
                else if (target>nums[middle]){
                    start = middle+1;
                }
                else end =middle-1;
            }
            else return end;
        }
        return -1;
    }


    // peak index in a mountain array -
    public int peakIndexInMountainArray(int[] arr) {

        int start = 0;
        int end = arr.length-1;

        while(start<end){
            int middle = (start+end)/2;
            if(arr[middle]>arr[middle+1]) end = middle;
            else if(arr[middle]<arr[middle+1]) start = middle+1;
        }
        return start;

    }

    // HARD - Done
    public int findInMountainArray(int target, int[] mountainArr) { //[1,5,2] 2 -> 2

        int peak = peakIndexInMountainArray(mountainArr);
        int left = binarySearch(mountainArr, target, 0, peak);
        if(left != -1){
            return left;
        }
        else {
            int right = orderAgnoisticBinarySearch(mountainArr, target, peak, mountainArr.length-1);
            return right;
        }
    }

    //Medium -  Search in rotated sorted array -

    // int array in ascending order with distinct elements but the array is left rotated to k times so
    // in order to apply binary search you have to first rotate it right by k times and then search for target.
    // eg -  nums = [4,5,6,7,0,1,2], target = 0 [4, 5, 6, 7, 0, 1, 2]

    /** My approach - its kind of find mountain peak problem where the peak would be the highest element
     * all the elements right to peak elements would come first in array and then the left side will come in order to get the sorted array
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;

        while(start<=end){
            int middle = (start+end)/2;
            if(nums[middle] == target) return middle;
            else if( nums[middle] <= nums[end]){
                if(target>nums[middle] && target<=nums[end]) start = middle+1;
                else end = middle-1;
            }
            else {
                if(target != nums[end]) end = end-1;
                else return end;
            }
        }
        return -1;
    }

    // Same rotated binary search for sorted array with duplicate values-


    // Rotation count of sorted array - the array is rotated ot right k times find k -
    public int findkRotation(int[] nums){
        int start = 0;
        int end = nums.length-1;

        while(start<=end){
            int middle = (start+end)/2;
            if(middle == start) return start+1;
            else if(nums[middle] < nums[end]){
                end = middle;
            }
            else if(nums[middle] > nums[end]){
                start = middle;
            }
        }
        return 0;
    }

    //410 - split-array-largest-sum - HARD
    /** Given an integer array nums and an integer k, split nums into k non-empty
     subarrays such that the largest sum of any subarray is minimized.
     Return the minimized largest sum of the split.
     A subarray is a contiguous part of the array. **/

    public int splitArray(int[] nums, int k) {

        int start = nums[0];
        int end = 0;

        for(int i=0; i<nums.length; i++){
            start = Math.min(start, nums[i]);
            end = end+nums[i];
        }

        // start binary search
        while(start<end){
            int middle = start + (end-start)/2;

            // calculate how many pieces we can divide this in
            int sum = 0;
            int pieces = 1;
            int minMaxSum = 0;

            for(int num: nums){

                if(sum + num > middle){
                    // you cannot add this elem in sub array you have to create a new one
                    sum = num; // so the num which on adding the sum > middle would be gone to a new array - sum->num && pieces++
                    pieces++;
                }
                else {
                    sum+=num;
                }
            }

            if(pieces > k){
                start = middle+1;
            }
            else{
                end = middle;
            }
        }
        return end;
    }

    /**
     * 875. Koko Eating Bananas
     * Medium
     * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
     * The guards have gone and will come back in h hours.
     * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas
     * from that pile.
     * If the pile has less than k bananas,
     * she eats all of them instead and will not eat any more bananas during this hour.
     * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
     * Return the minimum integer k such that she can eat all the bananas within h hours.
     *
     */

    public int minEatingSpeed(int[] piles, int h) {

        int start = piles[0];
        int end = piles[0];
        int count = 0;

        for(int i= 0; i< piles.length; i++){
            start = Math.min(start, piles[i]);
            end = Math.max(end, piles[i]);
        }

        while(start<end && count < h){

            int middle = start + (end-start)/2;

            for(int banana: piles){
                if(banana ==0){
                    continue;
                }
                else if(banana - middle >= 0) {
                    banana = banana - middle;
                    count++;
                }
                else if( banana - middle < 0){
                    banana = 0;
                    count++;
                }
            }

        }

        return 0;
    }
}












































































































