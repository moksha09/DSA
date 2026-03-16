package org.example.recursion.assignment.easy;

public class CheckForBalancedParenthesis {

    /**
     * Given an expression string exp, write a program to examine whether
     * the pairs and the orders of “{“, ”}”, ”(“, ”)”, ”[“, ”]” are correct in exp.
     * Input : exp = “[()]{}{[()()]()}”
     * Output : true
     *
     * Input : exp = “[(])”
     * Output : false
     */
    // n = length od exp
    static int check(char[] exp, int index){

        while(index<exp.length){

            char ch = exp[index];

            // case1 - open bracket -> recursively solve the inner expression -
            if(ch=='(' || ch=='{' || ch=='['){

                // find its matching close -
                int innerEnd = check(exp,index+1);
                // check if closing bracket match the opening bracket -
                if(!isMatching(ch, exp[innerEnd])){
                    return -1;
                }

                // skip ahead after matching pair
                index = innerEnd+1;

            } // case-2 -> Closing bracket -> return to previous caller
            else if(ch==')' || ch=='}' || ch==']'){
                return index; // caller will check if matching
            }
            // case-3 -> any other character skip
            else{
                index++;
            }
        }

        return index;

    }

    public static boolean isMatching(char open, char close){
        return (open == '(' && close == ')')
                || (open == '[' && close == ']')
                || (open == '{' && close == '}');
    }


    public static void main(String[] args){
        String input = "{[]}";

        if(check(input.toCharArray(),0)==input.length()){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
