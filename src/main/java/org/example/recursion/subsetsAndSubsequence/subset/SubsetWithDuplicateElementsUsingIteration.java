package org.example.recursion.subsetsAndSubsequence.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDuplicateElementsUsingIteration {

    // my approach - this wont work  - {1,2,2) works but {2,1,2} doesnt work
    // in order to make it work we need the duplicates to be together - i.e we need to sort the array -
    static List<List<Integer>> getSubsetWithDuplicates(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for(int num: arr){
            int n = outer.size();
            for (int i=0; i<n; i++){
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                // skipping the duplicates
                if(!outer.contains(inner)){
                    outer.add(inner);
                }
            }
        }
        return outer;

    }

    // kunal's approach - sorting step is necessary , but here after sorting
    // when we find a duplicate element, then rather than adding it in the total result of previous step
    // we will add that element only in the newly created subset of previous step i.e the RHS part

    static List<List<Integer>> getSubsetWithDuplicates2(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        // lets have 2 index -
        int start = 0;
        int end = 0;

        for(int i=0; i<arr.length; i++){
            start = 0;
            // if current and previous element from arr is same that means we have a duplicate; -
            // so start = previousEnd + 1;
            if(i>0 && arr[i]==arr[i-1]){
                start = end +1;
            }
            end = outer.size()-1;

            int n = outer.size();
            for (int j=start; j<n; j++){
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        return outer;

    }

    public static void main(String[] args){
        int[] arr = {2,1,2};
        List<List<Integer>> ans = getSubsetWithDuplicates(arr);
        System.out.println(ans);
    }
}
