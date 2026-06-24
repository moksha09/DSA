package org.example.dsa.recursion.assignment.easy;



public class RemoveConsecutiveDuplicatesFromString {

    /**
     * Input: s = "geeksforgeeks"
     * Output: geksforgeks
     * @param input
     */
    static String removeDuplicates(char[] input, int index){

        if(index==input.length-1){
            String str = "";
            return str+input[index];
        }
        if(index>=input.length){
            return "";
        }
            if(input[index]==input[index+1]){
                return input[index] + removeDuplicates(input, index+2);
            }else{
                return input[index] + removeDuplicates(input,index+1);
            }
    }

    public static void main(String[] args){
        String input = "aa";
        System.out.println(removeDuplicates(input.toCharArray(), 0));
    }
}
