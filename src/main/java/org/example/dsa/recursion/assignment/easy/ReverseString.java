package org.example.dsa.recursion.assignment.easy;

public class ReverseString {

    /**
     * Write a function that reverses a string.
     * The input string is given as an array of characters s.
     *
     * You must do this by modifying the input array in-place with O(1) extra memory.
     * @param s
     */
    static void reverseString(char[] s) {
        swap(s, 0);
    }

    static void swap(char[] s, int index){
        if(index>=s.length/2){
            return;
        }
        int n = s.length;
        char temp = s[index];
        s[index] = s[n-1-index];
        s[n-1-index] = temp;

        index = index+1;
        swap(s,  index);
    }

    public static void main(String[] args){
        char[] input = new char[] {'h','e','l','l','o'};
        reverseString(input);
        System.out.println(input);
    }
}
