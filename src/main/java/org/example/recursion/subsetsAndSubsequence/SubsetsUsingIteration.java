package org.example.recursion.subsetsAndSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsUsingIteration {

    static List<List<Integer>> getAllSubsets(int[] arr){
        List<List<Integer>> outerList = new ArrayList<>();

        // initially the outerlist will have an empty list -
        outerList.add(new ArrayList<>());

        // for each number in arr we will create a innerlist of same size of outerlist
        // then add that element in the list
        for(int num: arr){
            int n = outerList.size();
            for(int i=0; i<n; i++){
                // creating a copy of outeList
                List<Integer> innerList = new ArrayList<>(outerList.get(i));
                // then adding the number in the copied list
                innerList.add(num);
                outerList.add(innerList);
            }
        }

        return outerList;

    }
    public static void main(String[] args){

        int[] arr = {1,2,3};
        List<List<Integer>> ans = getAllSubsets(arr);
        System.out.println(ans);
    }
}
