package org.example.sorting.problems.assignment.easy;

import java.util.Arrays;

public class CanMakeAPFromSequence1502 {

    // AP - Difference between 2 consecutive elements are same.
    static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int difference = arr[1] - arr[0];
        for(int i=0; i<arr.length-1; i++){
            if(arr[i+1]-arr[i]!=difference){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){

    }
}
