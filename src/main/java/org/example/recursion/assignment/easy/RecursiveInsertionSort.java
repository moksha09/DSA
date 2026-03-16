package org.example.recursion.assignment.easy;

import java.util.Arrays;

public class RecursiveInsertionSort {

    static void recursiveInsertionSort(int[] num, int r, int c){
        if(r==num.length-1){
            return;
        }
        if(c>0){
            if(num[c]<num[c-1]){
                // swap
                int temp = num[c];
                num[c] = num[c-1];
                num[c-1] = temp;
            }
            recursiveInsertionSort(num, r, c-1);
        }
        recursiveInsertionSort(num,r+1, r+2);

    }

    public static void main(String[] args){
        int[] nums = new int[] {5,4,3,2,1};
        recursiveInsertionSort(nums, 0, 1);
        System.out.println(Arrays.toString(nums));
    }
}
