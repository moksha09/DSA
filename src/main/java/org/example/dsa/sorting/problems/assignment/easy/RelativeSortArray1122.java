package org.example.dsa.sorting.problems.assignment.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RelativeSortArray1122 {

    /**
     * Given two arrays arr1 and arr2, the elements of arr2 are distinct,
     * and all elements in arr2 are also in arr1.
     * Sort the elements of arr1 such that the relative ordering of items in
     * arr1 are the same as in arr2. Elements that do not appear in arr2 should
     * be placed at the end of arr1 in ascending order.
     *
     * Example 1:
     * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
     * Output: [2,2,2,1,4,3,3,9,6,7,19]
     *
     * Example 2:
     * Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
     * Output: [22,28,8,6,17,44]
     * @param arr1
     * @param arr2
     * @return
     */

    // MY APPROACH -BAD - BRUTE FORCE -
    static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        List<Integer> list = new ArrayList<>();

        // First lets get the arr2 elements from arr1 in same order
        for(int i=0; i<arr2.length; i++){
            for(int j=0; j<arr1.length; j++){
                if(arr2[i]==arr1[j]){
                    list.add(arr1[j]);
                }
            }
        }

        // lets get the remaining elements from arr1 which are not present in arr2 -
        List<Integer> remaining = new ArrayList<>();
        for(int num : arr1){
            if(list.contains(num)) continue;
            else{
                remaining.add((num));
            }
        }

        // sort the remaining elements in ascending order -
        remaining.sort((a,b)->{
            return Integer.compare(a,b);
        });

        // add the remaining elements back to the list
        list.addAll(remaining);

        // convert ArrayList into array
        for(int m=0; m<list.size(); m++){
            result[m] = list.get(m);
        }
        return result;

    }

    // Leetcode solution - Using COUNT SORT - Havent learnt it yet
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] f = new int[1001];
        for(int x : arr1){
            f[x] = f[x]+1;
        }
        int i=0;
        for(int x:arr2) while(f[x]-- >0) arr1[i++]=x;
        for(int x=0;x<1001;x++) while(f[x]-- >0) arr1[i++]=x;
        return arr1;
    }

    public static void main(String[] args){
        int[] arr1 = new int[] {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[] {2,1,4,3,9,6};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));

    }
}
