package org.example.dsa.recursion.subsetsAndSubsequence.stringsSubsequenceQuestions;

import java.util.ArrayList;

public class SubsequenceViaRecursion {
    /**
     * 1) Whenever there is permutation and combination - subsets are used.
     * 2) These are non-adjacent collection
     * 3) Order should matter i.e you cant have [a,b] and [b,a] both are the same thing so we will have [a,b]
     * Example- You are given an array = [3,5,9] -> [3],[5],[9],[3,5],[5,9],[3,9],[3,5,9]
     * [a,b,c] - [a,b],[a,c],[b,c],[a],[b],[c],[a,b,c]
     *
     * In any subset you see, you can see that it may be taking some element and ignoring a few element.
     * THIS PATTERN OF IGNORING SOME ELEMENT AND IGNORING/REMOVING SOME ELEMENT IS KNOW AS SUBSET PATTERN - VERY IMPORTANT
     * SUBSETS ARE FOR ARRAYS AND SUBSEQUENCE ID FOR STRINGS
     */

    // Let's solve this using recursion -

    /**
     * 1) We will processed and unprocessed . Initially processed ="" and unprocessed = "abc".
     * 2) For every character we have 2 choices - either take it or ignore it
     * 3) Lets say we take
     */

    // Printing all subsequence -
    static void getAllSubsequence(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        // Take the first character
        char ch = unprocessed.charAt(0);
        //Then make 2 recursion calls -
        // 1) taking/adding the character -
        getAllSubsequence(processed+ch,unprocessed.substring(1));
        // 2) ignore the character -
        getAllSubsequence(processed, unprocessed.substring(1));

    }

    // Returning a list of subsequence -
    static ArrayList<String> getAllSubsequence2(String processed, String unprocessed){

        // base condition - returning the answer in base condition
        if(unprocessed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        ArrayList<String> answerFromLeft = getAllSubsequence2(processed+ch,unprocessed.substring(1));
        ArrayList<String> answerFromRight =  getAllSubsequence2(processed, unprocessed.substring(1));

        answerFromLeft.addAll(answerFromRight);
        return answerFromLeft;

    }
    public static void main(String[] args){
        String input = "abc";
        System.out.println(getAllSubsequence2("",input));
    }
}
