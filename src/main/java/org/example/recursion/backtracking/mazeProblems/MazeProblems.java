package org.example.recursion.backtracking.mazeProblems;

import java.util.ArrayList;

public class MazeProblems {

    // Calculate the number of ways the user can take to reach from point A(3,3) to B(1,1) in a matrix
    // Only right and down directions are allowed
    //  (3,3)  (3,2) (3,1)
    //  (2,3)  (2,2) (2,1)
    //  (1,3)  (1,2) (1,1)

    static int count(int r, int c){
        // Base case - whenever either the row or column hits 1 return 1
        if(r==1 || c==1){
            return 1;
        }
        //RHS - Decreasing row by 1 -
        int left = count(r-1,c);
        //LHS - decreasing column by 1
        int right = count(r,c-1);
        return left+right;

    }

    // Now rather than just giving the number of ways you now have to print the actual path
    // the paths would be the permutations -> hence our approach should be of processed and unprocessed

    static void path(String p, int r, int c){
        // base condition - when both the row and column become 1 we print the processed string as our path
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
        if(r>1){
            // left -
            path(p +"D",r-1, c);
        }
        if(c>1){
            // right -
            path(p+"R", r, c-1);
        }
    }

    // return the answer in an arraylist -
    static ArrayList<String> listPaths(String p, int r, int c){
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> result = new ArrayList<>();
        if(r>1){
            result.addAll(listPaths(p+"D", r-1, c));
        }
        if(c>1){
            result.addAll(listPaths(p+"R", r, c-1));
        }
        return result;
    }

    // Now ets say we can move 3 ways - D = down, R = right, S = diagonal
    // when can you go diagonally ?-> r==c

    static ArrayList<String> listPaths2(String p, int r, int c){
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> result = new ArrayList<>();
        if(r==c){
            result.addAll(listPaths2(p+"S", r-1, c-1));
        }
        if(r>1){
            result.addAll(listPaths2(p+"D", r-1, c));
        }
        if(c>1){
            result.addAll((listPaths2(p+"R", r, c-1)));
        }
        return result;
    }

    // when you land on a new cell check whether that is river or not i.e (r-=1 && c==1)
    // if you land on river stop the recursion for that call
    static void pathWithObstacle(String p, boolean[][] matrix, int r, int c){
        if(r==2 && c==2){
            System.out.println(p);
            return;
        }
        if(!matrix[r][c]) {
            return;  // stopping the recursion when it hits the obstacle -> i.e we now wont make any future calls
        }
        if(c<matrix.length-1){
            pathWithObstacle(p+"R", matrix, r, c+1);
        }
        if(r<matrix.length-1){
            pathWithObstacle(p+"D", matrix, r+1, c);
        }
    }
    public static void main(String[] args){
        boolean[][] matrix = new boolean[3][3];
        matrix[0] = new boolean[] {true, true, true};
        matrix[1] = new boolean[] {true, false, true};
        matrix[2] = new boolean[] {true, true, true};

        pathWithObstacle("",matrix, 0,0);
    }
}
