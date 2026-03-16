package org.example.recursion.assignment.medium;

public class KthSymbolInGrammer {


    /**
     * We build a table of n rows (1-indexed). We start by writing 0 in the 1st row.
     *  Now in every subsequent row, we look at the previous row and replace each
     *  occurrence of 0 with 01, and each occurrence of 1 with 10.
     * For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
     * Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.

     * Example 1:
     * Input: n = 1, k = 1
     * Output: 0
     * Explanation: row 1: 0
     *
     * Example 2:
     * Input: n = 2, k = 1
     * Output: 0
     * Explanation:
     * row 1: 0
     * row 2: 01
     */

    static int kthGrammar(int n, int k) {
        String nthRow = nthRow(n, 1, "0");
        return nthRow.charAt(k-1) - '0';
    }

    static String nthRow(int n, int row, String current){
        // base case -
        if(row==n){
            return current;
        }

        char[] ch = current.toCharArray();
        StringBuilder str = new StringBuilder();
        for(char c : ch){
            if(c=='0'){
                str.append("01");
            }else if(c=='1'){
                str.append("10");
            }
        }
        return nthRow(n, row+1, str.toString());
    }

    public static void main(String[] args){
        System.out.println(kthGrammar(30,434991989));

    }
}
