package org.example.recursion.assignment.easy;

import java.util.ArrayList;
import java.util.List;

public class FindAallPalindromicPartitionOfString {

    static List<String> palindromes(String input, int beginIndex){
        if(beginIndex==input.length()){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        for(int i=beginIndex; i<input.length(); i++){
            String substring = input.substring(beginIndex,i+1);
            if(isPalindrome(substring)){
                result.add(substring);
            }
        }
        result.addAll(palindromes(input, beginIndex+1));
        return result;
    }

    static boolean isPalindrome(String str){
        char[] ch = str.toCharArray();
        int n = ch.length;
        for(int i=0; i<=n/2; i++){
            if(ch[i]!=ch[n-i-1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String input = "abcba";
        System.out.println(palindromes(input, 0));
    }
}
