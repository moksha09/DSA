package org.example.dsa.recursion.subsetsAndSubsequence.stringsSubsequenceQuestions;

public class SkipAStringInString {

    // 1) Taking answer in argument - the answer will be passed to future recursive function call.

    static String skipApple1(String unprocessed, String processed){
        if(unprocessed.isEmpty()){
            return processed;
        }
        char ch = unprocessed.charAt(0);

        if(unprocessed.startsWith("apple")){
            return skipApple1(unprocessed.substring(5),processed);
        }else{
            return skipApple1(unprocessed.substring(1),processed+ch);
        }
    }

    public static void main(String[] args){
        String up = "asdfgapplerthj";
        String p = skipApple1(up,"");
        System.out.println(p);

    }
}
