package org.example.dsa.recursion.sorting;

import java.util.Arrays;

public class BubbleSortQuickSortRecursion {
    public static void main(String[] args){
       // pattern2(4,0);
        // pattern3(3,0);
        int[] arr = {1,3,2,4,5,6};
        selectionSort(arr, arr.length, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    // Patterns using recursion -
    /**
     * n=4
     *  ####
     *  ###
     *  ##
     *  #
     *
     *
     */
    // My approach -
    static void pattern1(int n){
        if(n==0){
            return;
        }
        for(int i=1; i<=n; i++){
            System.out.print("#");
        }
        System.out.println();
        pattern1(n-1);
    }

    // Real one -
    static void pattern2(int r , int c){
        if(r == 0){
            return;
        }
        if(c<r){
            System.out.print("#");
            pattern2(r, c+1);
        } else{
            System.out.println();
            pattern2(r-1, 0);
        }
    }

    // Printing normal triangle i.e inverse of pattern2 -
    /**
     * #
     * ##
     * ###
     * ####
     */
    static void pattern3(int r, int c){
        if(r==0){
            return;
        }
        if(c<r){
            pattern3(r, c+1);
            System.out.print("#");
        } else{
            pattern3(r-1, 0);
            System.out.println();
        }
    }

    // Bubble sort using recursion - similar to pattern2
    static void bubbleSort(int[] arr, int r , int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            if (arr[c] > arr[c + 1]) {
                // do a  swap
                int temp = arr[c];
                arr[c] = arr[c + 1];
                arr[c + 1] = temp;
            }
            bubbleSort(arr, r, c + 1);
        }
        else{
            bubbleSort(arr, r-1, 0);
        }
    }

    // SelectionSort using recursion

    static void selectionSort(int[] arr, int r, int c, int max){
        if(r==0) return;

        if(c<r){
            if(arr[c] > arr[max]){
                selectionSort(arr, r, c+1, c);
            } else {
                selectionSort(arr, r, c+1, max);
            }
        } else{
            int temp = arr[max];
            arr[max] = arr[r-1];
            arr[r-1] = temp;

            selectionSort(arr,r-1, 0, 0);
        }
    }

}
