package org.example.dsa.recursion.subsetsAndSubsequence.subset;

import java.util.ArrayList;
import java.util.List;

public class SubsetUsingRecursion {

    static List<List<Integer>> subset(int[] arr, int index, List<Integer> processed){
        // base case -
        if(index==arr.length){
            List<List<Integer>> list = new ArrayList<>();
            // EXTREMELY IMPORTANT - YOU NEED TO MAKE A COPY OF PROCESSED WHILE ADDING OR ELSE YOU WOULD BE PASSING A REFERENCE
            // TO PROCESSED IN THE LIST AND SINCE THE PROCESSED LIST MUTABLE AND KEEP CHANGING IN FUTURE CALLS THOSE
            // CHANGES WILL BE SHOWN IN THIS LIST TOO
            // SO REMEMBER IN RECURSION ADN BACKTRACKING WHEN WE ARE WORKING WITH A MUTABLE LIST
            // ALWAYS MAKE A COPY
            // Backtracking + mutable objects = you MUST copy
            ///  Never store a mutable object directly in recursion results. Always clone it.
            list.add(new ArrayList<>(processed));
            return list;
        }

        // taking the element
        Integer elem = arr[index];
        processed.add(elem);
        List<List<Integer>> lhs = subset(arr, index+1, processed);
        processed.remove(processed.size()-1);

        //ignore the elem
        List<List<Integer>> rhs = subset(arr, index+1, processed);

        lhs.addAll(rhs);
        return lhs;
    }

    // ONLY PRINT SUBSET OF SIZE 2 -
    static List<List<Integer>> subset2(int[] arr, int index, List<Integer> processed){
        // base case -
        if(index==arr.length){
            List<List<Integer>> list = new ArrayList<>();
            if(processed.size()==2){
                list.add(new ArrayList<>(processed));
            }
            return list;
        }

        // taking the element
        Integer elem = arr[index];
        processed.add(elem);
        List<List<Integer>> lhs = subset2(arr, index+1, processed);
        processed.remove(processed.size()-1);

        //ignore the elem
        List<List<Integer>> rhs = subset2(arr, index+1, processed);

        lhs.addAll(rhs);
        return lhs;
    }

    public static void main(String[] args){
        int[] arr = new int[] {1,2,3};
        System.out.println(subset2(arr, 0, new ArrayList<>()));
    }
}
