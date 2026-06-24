package org.example.dsa.sorting;

import java.util.Arrays;

import static org.example.dsa.sorting.BubbleSort.swap;

public class CyclicSort {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    // *** When given numbers from range 1,N => use cyclic sort
    static void cyclicSort(int[] arr){
        // since we are not incrementing i after each swap we would be using while loop instead of for loop
        int i = 0;
        while(i < arr.length){
            // check if the ith element's value is equal to i+1 or not
            if (arr[i] != i+1){
                // if not swap with correct index
                swap(arr,i, arr[i]-1);
            } else{
                i++;
            }
        }
    }
}
