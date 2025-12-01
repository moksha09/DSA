package org.example.recursion.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    // MEDIUM - LEETCODE - 17
    public static Map<String, String> map = Map.of("2","abc",
            "3","def",
            "4", "ghi",
            "5", "jkl",
            "6", "mno",
            "7", "pqrs",
            "8", "tuv",
            "9", "wxyz");

    static List<String> letterCombinations(String digits){
        return combinations("", digits);
    }

    private static List<String> combinations(String p, String up){

        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        String str = map.get(ch+""); //abc
        int n = str.length();

        List<String> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            char ch2 = str.charAt(i);
            result.addAll(combinations(p+ch2, up.substring(1)));
        }
        return result;
    }

    public static void main(String[] args){

        System.out.println(letterCombinations("22"));

    }
}
