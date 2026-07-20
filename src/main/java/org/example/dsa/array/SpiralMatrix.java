package org.example.dsa.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n-1;

        while(top<=bottom && left<=right){

            for(int i=left; i<=right; i++){
                result.add(matrix[top][i]);
            }
            top++;

            for(int i=top; i<=bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;

            for(int i=right; i>=left; i--){
                result.add(matrix[bottom][i]);
            }
            bottom--;

            for(int i=bottom; i>=top; i--){
                result.add(matrix[i][left]);
            }
            left++;
        }

        return result;
    }
}
