package org.example.dsa.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void bubbleSort(int[] arr){

        // run the steps (n-1) times
        for(int i=0; i< arr.length; i++){
            boolean swapped;
            swapped = false;
            // for each step, max item will come at the last respective index
            for(int j=1; j < arr.length-i; j++){
                // swap if the item is smaller than the previous item
                if(arr[j]  < arr[j-1]){
                    swap(arr, j, j-1);
                    swapped = true;
                }
            }
            // if you didn't swap for a particular value of i , then the array is sorted
            if(!swapped) break;
        }
    }

    public static void swap(int[] arr, int first , int second){

        int temp = arr[first];
        arr[first]= arr[second];
        arr[second] = temp;

    }

}
