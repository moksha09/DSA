package org.example.dsa.recursion.assignment.easy;

public class FirstUppercaseLetterInString {
    /**
     * Input : geeksforgeeKs
     * Output : K
     */

    static char findFirstUpperCase(String text){
        if(text.isEmpty()){
            return '0';
        }
        char ch = text.charAt(0);
        if(Character.isUpperCase(ch)){
            return ch;
        } else{
            return findFirstUpperCase(text.substring(1));
        }

    }
    public static void main(String[] args){
        String input = "gee";
        System.out.println(findFirstUpperCase(input));
    }
}
