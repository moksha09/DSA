package org.example.dsa.sorting;


import java.util.Arrays;

import static org.example.dsa.sorting.BubbleSort.swap;

public class InsertionSort {
    public static void main(String[] args){

        int[] arr = {5,4,3,1,2};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void insertionSort(int[] arr){
        // i will be from 0 to n-2
        for(int i=0; i<arr.length-1; i++){

            // for each pass/i, we will sort the LHS
            for(int j=i+1; j>0; j--){
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                }
                else break;
            }
        }
    }
}
