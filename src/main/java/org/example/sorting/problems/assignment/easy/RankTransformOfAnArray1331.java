package org.example.sorting.problems.assignment.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformOfAnArray1331 {

    static int[] arrayRankTransform(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        int[] result2 = new int[arr.length];
        Arrays.sort(arr);
        int[] result = new int[arr.length];
        result[0] = 1;

        for(int i=1; i<arr.length; i++){
            if(arr[i]==arr[i-1]){
                result[i] = result[i-1];
            } else{
                result[i] = result[i-1]+1;
            }
        }

        // storing rank in hashmap -
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<result.length; i++){
            map.putIfAbsent(arr[i],result[i]);
        }

        for(int i=0; i< copy.length; i++){
            result2[i] = map.get(copy[i]);
        }

        return result2;


    }
    public static void main(String[] args){
        int[] arr = new int[] {40, 30, 20, 10};
        arrayRankTransform(arr);
    }
}
