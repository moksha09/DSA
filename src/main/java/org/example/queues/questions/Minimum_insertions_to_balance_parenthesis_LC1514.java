package org.example.queues.questions;

import java.util.Stack;

public class Minimum_insertions_to_balance_parenthesis_LC1514 {

    /**
     * Given a parentheses string s containing only the characters '(' and ')'.
     * A parentheses string is balanced if:
     *
     * Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
     * Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
     * In other words, we treat '(' as an opening parenthesis and '))' as a closing parenthesis.
     *
     * For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.
     * You can insert the characters '(' and ')' at any position of the string to balance it if needed.
     *
     * Return the minimum number of insertions needed to make s balanced.
     */

    // greedy -
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        int neededRight = 0; // how many ')' are still needed
        int insertions = 0;  // how many we inserted

        for(char c : ch){
            if(c=='('){
                if(neededRight%2 != 0){
                    insertions += 1;
                }
                neededRight += 2;
            }else{
                neededRight -= 1;
                if(neededRight<0){
                    insertions += 1;
                    neededRight = 1;
                }
            }
        }

        return insertions + neededRight;
    }



}
