package org.example.dsa.queues.questions;

import java.util.Stack;

public class Minimum_add_to_make_parentheses_valid_LC_921 {

    public static int minAddToMakeValid(String s) {

        Stack<Character> stack = new Stack<>();

        char[] input = s.toCharArray();
        for (char c : input) {
            if(stack.empty()){
                stack.push(c);
            }else{
                if(isOpen(c)){
                    stack.push(c);
                }else{
                    char match = match(c);
                    if(stack.peek().equals(match)){
                        stack.pop();
                    }else{
                        stack.push(c);
                    }
                }
            }
        }

        return stack.size();
    }

    public static char match(char c){
        if(c == ')'){
            return '(';
        }else if(c == '}'){
            return '{';
        }else{
            return '[';
        }
    }

    public static boolean isOpen(char c){
        return ((c=='(') || (c=='{') || (c=='['));
    }

    public static void main(String[] args){
        String input = "()))((";
        System.out.println(minAddToMakeValid(input));

    }
}
