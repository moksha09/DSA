package org.example.recursion.backtracking.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NQueensProblem {



    static int nQueens(boolean[][] board, int row){
        // base condition - when the row number become length of the board
        if(row==board.length){
            display(board);
            System.out.println();
            return 1;
        }
        // Placing the queen and checking for every row and column -
        int count = 0;
        for(int col = 0; col< board.length; col++){
            // place the queen if it is safe
            if(isSafe(board, row, col)){
                board[row][col] = true;
                // this row is placed try to see the below ones -
                count = count+ nQueens(board, row+1);
                // change it back to normal -
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int r, int c){
        // check vertical row -
        for(int i=0; i<r; i++){
            if(board[i][c]){
                return false;
            }
        }

        // check for left diagonal
        for (int i=1; i<=Math.min(r, c); i++){
            if(board[r-i][c-i]){
                return false;
            }
        }

        // check fo right diagonal
        int maxRight = Math.min(r, board.length-c-1);
        for(int i=1; i<=maxRight; i++){
            if(board[r-i][c+i]){
                return false;
            }
        }

        return true;
    }

    // to print the answer board
    private static void display(boolean[][] board){
        for(boolean[] row: board){
            for(boolean element: row){
                if(element){
                    System.out.print("Q");
                }else{
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }

    // leetcode problem solution  -

    /**
     * Input: n = 4
     * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return nQueens2(board, 0);
    }

    static List<List<String>> nQueens2(boolean[][] board, int row){
        // base condition - when the row number become length of the board
        if(row==board.length){
            List<List<String>> list = new ArrayList<>();
            list.add(display2(board));
            return list;
        }
        // Placing the queen and checking for every row and column -
        List<List<String>> result = new ArrayList<>();
        for(int col = 0; col< board.length; col++){
            // place the queen if it is safe
            if(isSafe(board, row, col)){
                board[row][col] = true;
                // this row is placed try to see the below ones -
                result.addAll(nQueens2(board, row+1));
                // change it back to normal -
                board[row][col] = false;
            }
        }
        return result;
    }

    static List<String> display2(boolean[][] board){
        List<String> result = new ArrayList<>();

        for(int i=0; i<board.length; i++){
            String p = "";
            for(int j=0; j< board[0].length; j++){
                if(board[i][j]){
                    p = p + "Q";
                }else{
                    p = p + ".";
                }
            }
            result.add(p);
        }
        return result;
    }



    public static void main(String[] args){
        boolean[][] board = new boolean[4][4];
        // System.out.println(nQueens(board, 0));
        System.out.println(nQueens2(board, 0));


    }
}
