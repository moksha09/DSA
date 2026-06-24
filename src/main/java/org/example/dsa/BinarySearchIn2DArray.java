package org.example.dsa;

import java.util.Arrays;

public class BinarySearchIn2DArray {

    public static void main(String[] args){
        int[][] arr = {
                {10, 20, 30, 40},
                {11, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };

        System.out.println(Arrays.toString(search(arr, 37)));

    }

    // Search for 2D array with sorted row wise and col wise elem.
    static int[] search(int[][] arr, int target){
        int start = 0;
        int end = arr[0].length-1;

        while(start < arr.length && end >=0){
            if(arr[start][end] == target) return new int[] {start, end};
            else if (arr[start][end] > target) {
                end--;
            }
            else{
                start++;
            }
        }
        return null;
    }

    static int[] sortedSearch(int[][] arr, int target){

        int r = arr.length;
        int c = arr[0].length; // Beware the matrix might be empty

        if(arr.length == 1) {
            int result = simpleBS(arr[0], target);
            return new int[] {0, result};
        }
        else {
            return null;
        }
    }

    static int simpleBS(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        while(start<=end){
            int middle = start + (end-start)/2;

            if(arr[middle] == target) return middle;
            else if(arr[middle] > target) end = middle-1;
            else start = middle+1;
        }
        return -1;
    }
}
