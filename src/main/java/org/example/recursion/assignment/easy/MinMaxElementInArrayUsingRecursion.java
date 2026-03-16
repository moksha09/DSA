package org.example.recursion.assignment.easy;

import java.util.ArrayList;

import static java.util.Collections.min;

public class MinMaxElementInArrayUsingRecursion {

    /**
     * Input: arr[] = [1, 4, 3, -5, -4, 8, 6]
     * Output: [-5, 8]
     * Explanation: -5 is the minimum and 8 is the maximum element in the array
     *
     * Input: arr[] = [12, 3, 15, 7, 9]
     * Output: [3, 15]
     * Explanation: 3 is the minimum and 15 is the maximum element in the array
     *
     * @param arr
     * @param index
     * @return
     */
    // MY APPROACH -

    /**
     * First lets right a recursive function to find the minimum of an array -
     */
    static int findMin(int[] arr, int index){
        // base condition  - last element
        if(index==arr.length-1){
            return arr[index];
        }

        //Recursive step -
        int minRest = findMin(arr, index+1);
        return Math.min(minRest, arr[index]);

    }

    /**
     * Similarly noe lets try to calculate the max -
     */
    static int findMax(int[] arr, int index){
        // base condition - when index reaches the last element -
        if(index==arr.length-1){
            return arr[index];
        }

        // recursive call -
        int maxRest = findMax(arr, index+1);
        return Math.max(arr[index], maxRest);
    }

    /**
     * Now lets to implement both of these  -
     * @param arr
     * @return
     */
    static ArrayList<Integer> findMinMaxRec(int[] arr, int index){
        ArrayList<Integer> result = new ArrayList<>();
        result.add(findMin(arr, index));
        result.add(findMax(arr, index));
        return result;
    }

    // another way -
    static ArrayList<Integer> findMinMaxRec2(int[] arr, int index){
        // base condition -
        if(index==arr.length-1){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(arr[index]);
            list.add(arr[index]);
            return list;
        }

        // recursive call -
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> minMaxRest = findMinMaxRec2(arr, index+1);
        Integer min = Math.min(minMaxRest.get(0), arr[index]);
        Integer max = Math.max(minMaxRest.get(1), arr[index]);
        result.add(min);
        result.add(max);
        return result;
    }

    public static void main(String[] args){
        int[] arr = new int[] {1, 4, 3, -5, -4, 8, 6};
        System.out.println(findMinMaxRec2(arr, 0));
    }
}
