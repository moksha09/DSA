package org.example.sorting;

import java.util.Arrays;

import static org.example.sorting.BubbleSort.swap;

public class SelectionSort {

    public static void main(String[] args){
        int[] arr = {3,-1, 0, 2};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void selectionSort(int[] arr){

        for(int j=0; j<arr.length; j++){
            // get the maximum item of the array
            int lastIndex = arr.length-1-j;
            int maxIndex = getMaxIndex(arr,0, lastIndex);

            // swapping the max element to the last respective index
            swap(arr, maxIndex, lastIndex);
        }

    }

    private static int getMaxIndex(int[] arr, int start, int end){

        int max = start;

        for(int i=start; i<end; i++){
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        return max;
    }
}
