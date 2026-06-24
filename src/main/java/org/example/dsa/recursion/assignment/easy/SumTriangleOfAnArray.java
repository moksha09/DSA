package org.example.dsa.recursion.assignment.easy;

import java.util.Arrays;

public class SumTriangleOfAnArray {

    /**
     * Input : A = {1, 2, 3, 4, 5}
     * Output : [48]
     *          [20, 28]
     *          [8, 12, 16]
     *          [3, 5, 7, 9]
     *          [1, 2, 3, 4, 5]
     *
     * Explanation :
     * Here,   [48]
     *         [20, 28] -->(20 + 28 = 48)
     *         [8, 12, 16] -->(8 + 12 = 20, 12 + 16 = 28)
     *         [3, 5, 7, 9] -->(3 + 5 = 8, 5 + 7 = 12, 7 + 9 = 16)
     *         [1, 2, 3, 4, 5] -->(1 + 2 = 3, 2 + 3 = 5, 3 + 4 = 7, 4 + 5 = 9)
     * @param A
     */

    // MY APPROACH -

    /**
     * 1) First lets think for the opposite where we are printing the array first and then at each level we are reducing one each
     * 2) Base case - if the length of array = 1 return that array
     * 3) Computation
     * 4) Recursion Call
     */
    static void printTriangle(int[] A){
        if(A.length==1){
            System.out.println(Arrays.toString(A));
            return;
        }
        System.out.println(Arrays.toString(A));
        int n = A.length;
        int[] r = new int[n-1];
        for(int i=0; i<n-1; i++){
            r[i] = A[i]+A[i+1];
        }
        printTriangle(r);

    }

    /**
     * Printing in reverse order -Just print after the recursion call
     */
    static void printTriangleReverse(int[] A){
        if(A.length==1){
            System.out.println(Arrays.toString(A));
            return;
        }
        int n = A.length;
        int[] r = new int[n-1];
        for(int i=0; i<n-1; i++){
            r[i] = A[i]+A[i+1];
        }
        printTriangleReverse(r);
        System.out.println(Arrays.toString(A));
    }

    public static void main(String[] args){
        int[] A = new int[] {1,2,3,4,5};
        printTriangleReverse(A);
    }
}
