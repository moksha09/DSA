package org.example.linked_list.sorting;

import java.util.Arrays;

public class BubbleSortPractiseForArray {

    public static void bubbleSort(int[] arr, int n){

        // base condition -
        if(n==1){
            return; // already sorted
        }
        for(int i=0; i<n-1; i++){
            if(arr[i]>arr[i+1]){
                // swap
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        bubbleSort(arr, n-1);
    }

    public static void main(String[] args){
        int[] arr =new int[] {4, 3, 1, 2, 5};
        bubbleSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
