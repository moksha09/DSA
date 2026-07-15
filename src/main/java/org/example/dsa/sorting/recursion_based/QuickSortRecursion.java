package org.example.dsa.sorting.recursion_based;

import java.util.Arrays;

public class QuickSortRecursion {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

        // internal sorting algo in java -> go to the Arrays class and see the method for details -
        Arrays.sort(arr); // Uses DualPivotQuickSort ->O(nlogn) -> faster than One pivot quicksort
    }

    /**
     * Here low and high are for figuring out which part of array we are working on
     * start and end are for swapping comparison
     * @param arr
     * @param low
     * @param high
     */

    static void quickSort(int[] arr, int low, int high){
        if(low>=high){
            return;
        }

        int start = low;
        int end = high;

        // choose a pivot -
        int middle = (start+end)/2;
        int pivot = arr[middle];

        while(start <= end){

            // also a reason why if its already sorted it will not sort unlike Merge sort
            while(arr[start] < pivot){
                start++;
            }

            while(arr[end] > pivot){
                end--;
            }

            if(start <= end){
                // swap -
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                start++;
                end--;
            }
        }

        // Now the pivot is at correct index please sort two halves now
        quickSort(arr,low,end);
        quickSort(arr,start,high);

    }
}
