package org.example.recursion.backtracking.mazeProblems;

import java.util.Arrays;

public class GettingAllPaths {

    // all direction are allowed - U, D, R, L
    static void getAllPaths(String p, boolean[][] matrix, int r, int c){
        if(r== matrix.length-1 && c== matrix.length-1){
            System.out.println(p);
            return;
        }
        if(!matrix[r][c]){
            return;
        }

        // I am considering this block in my path hence setting it as false
        matrix[r][c] = false;

        if(r< matrix.length-1){
            getAllPaths(p+"D",matrix, r+1, c);
        }

        if(c< matrix.length-1){
            getAllPaths(p+"R", matrix, r, c+1);
        }

        if(r>0){
            getAllPaths(p+"U", matrix, r-1, c);
        }

        if(c>0){
            getAllPaths(p+"L", matrix, r, c-1);
        }

        // this line is where the function ends
        // hence before the function gets removed, also remove the changes that were made by the function
        matrix[r][c] = true;
    }

    // now lets print the path matrix and the paths -
    static void allPathsPrint(String p, boolean[][] matrix, int r, int c, int[][] path, int step){
        if(r== matrix.length-1 && c== matrix.length-1){
            path[r][c] = step;
            for(int[] arr: path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            return;
        }
        if(!matrix[r][c]){
            return;
        }

        // I am considering this block in my path hence setting it as false
        matrix[r][c] = false;
        path[r][c] = step;

        if(r< matrix.length-1){
            allPathsPrint(p+"D",matrix, r+1, c, path, step+1);
        }

        if(c< matrix.length-1){
            allPathsPrint(p+"R", matrix, r, c+1, path, step+1);
        }

        if(r>0){
            allPathsPrint(p+"U", matrix, r-1, c, path, step+1);
        }

        if(c>0){
            allPathsPrint(p+"L", matrix, r, c-1, path, step+1);
        }

        // this line is where the function ends
        // hence before the function gets removed, also remove the changes that were made by the function
        matrix[r][c] = true;
        path[r][c] = 0;
    }


    public static void main(String[] args){
        boolean[][] matrix = new boolean[3][3];
        matrix[0] = new boolean[] {true, true, true};
        matrix[1] = new boolean[] {true, true, true};
        matrix[2] = new boolean[] {true, true, true};

        int[][] path = new int[matrix.length][matrix[0].length];
        allPathsPrint("", matrix, 0, 0 , path, 1);
    }
}
