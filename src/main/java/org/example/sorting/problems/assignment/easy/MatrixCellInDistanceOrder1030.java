package org.example.sorting.problems.assignment.easy;

import java.util.Arrays;

public class MatrixCellInDistanceOrder1030 {
    /**
     * You are given four integers row, cols, rCenter, and cCenter.
     * There is a rows x cols matrix and you are on the cell with the coordinates (rCenter, cCenter).
     *
     * Return the coordinates of all cells in the matrix, sorted by their distance from (rCenter, cCenter)
     * from the smallest distance to the largest distance. You may return the answer in any order that satisfies this condition.
     *
     * The distance between two cells (r1, c1) and (r2, c2) is |r1 - r2| + |c1 - c2|.
     */

    // MyApproach -
    static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        // First lets create an array with all the indexes -
        int[][] matrix = new int[rows*cols][2];

        // first get all index in an array
        int k=0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int[] index = new int[] {i,j};
                matrix[k] = index;
                k++;
            }
        }

        // then sort that array based on the distance -
//        // bubble sort -
//        for(int m=0; m<rows*cols; m++){
//            boolean isSwapped = false;
//            for(int n=1; n<rows*cols-m; n++){
//                if(distanceOf(matrix[n],rCenter,cCenter)<distanceOf(matrix[n-1],rCenter,cCenter)){
//                    // swap
//                    int[] temp = matrix[n];
//                    matrix[n] = matrix[n-1];
//                    matrix[n-1] = temp;
//                    isSwapped = true;
//                }
//            }
//            if(!isSwapped) break;
//        }

        // Sort using arrays -
        Arrays.sort(matrix,(point1,point2)->{
            int dist1 = distanceOf(point1,rCenter,cCenter);
            int dist2 = distanceOf(point2,rCenter,cCenter);
            return Integer.compare(dist1,dist2);
        });


        return matrix;

    }

    private static int distanceOf(int[] index, int rCenter, int cCenter){
        return Math.abs(rCenter-index[0])+Math.abs(cCenter-index[1]);
    }

    public static void main(String[] args){
        allCellsDistOrder(2,2,1,0);
    }
}