package org.example.dsa.queues.questions;

import java.util.Stack;

public class ValidParentheses_LC20 {

    public static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        char[] par = s.toCharArray();
        for (char c : par) {
            String str = c + "";
            if (isOpen(str)) {
                stack.push(str);
            } else {
                if(stack.empty()){
                    return false;
                }
                String close = match(str);
                if (stack.peek().equals(close)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();

    }

    public static boolean isOpen(String c){
        return c.equals("(") || c.equals("{") || c.equals("[") ;
    }
    public static String match(String openingBracket){
        if(openingBracket.equals(")")) {
            return "(";
        }else if (openingBracket.equals("}")){
            return "{";
        }
        else {
            return "[";
        }
    }

    // optimized solution-
   public boolean isValidParenthesis(String input){
       Stack<Character> stack = new Stack<>();

       for(char ch : input.toCharArray()){
           if(ch == '('){
               stack.push(')');
           }else if(ch == '{'){
                stack.push('}');
           }else if(ch == '['){
               stack.push(']');
           } else {
               if(stack.empty() || stack.pop()!=ch){
                   return false;
               }
           }
       }
       return stack.isEmpty();
   }

    public static void main(String[] args){
        String input = "]";
        System.out.println(isValid(input));

    }
}
