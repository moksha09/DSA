package org.example.dsa.slidingWindow;

public class Main {

    public static void main(String[] args){
//        int[] arr = new int[] {100, 200, 300, 400, 100, 200};
//        int k  = 3;
//
//        MaximumSumOfSubArray maximumSumOfSubArray = new MaximumSumOfSubArray();
//        System.out.println(maximumSumOfSubArray.maxSum(arr, k));

        LongestSubstringWithoutDuplicateChar l = new LongestSubstringWithoutDuplicateChar();

        String s="abcabcbb";
        System.out.println(l.lengthOfLongestSubstring(s));

    }
}
