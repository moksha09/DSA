package org.example.dsa.array;

import java.util.Arrays;

public class Rotate2DArray {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // transpose -
        transpose(matrix, n);
        reverseRows(matrix, n);

    }

    public void reverseRows(int[][] matrix, int n){
        for(int[] row: matrix){
            int start = 0;
            int end = n-1;
            while(start<end){
                int temp = row[start];
                row[start] = row[end];
                row[end] = temp;
                start++;
                end--;
            }
        }
        System.out.println("Matrix after reverse - ");
        for(int[] row : matrix){
            System.out.println(Arrays.toString(row));
        }
    }

    public void transpose(int[][] matrix, int n){
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println("Matrix after transpose - ");
        for(int[] row : matrix){
            System.out.println(Arrays.toString(row));
        }
    }
}
