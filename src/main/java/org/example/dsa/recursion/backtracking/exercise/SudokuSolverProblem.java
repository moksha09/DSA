package org.example.dsa.recursion.backtracking.exercise;

public class SudokuSolverProblem {

    static boolean solve(int[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyCellLeft = true;

        // this is how we are replacing the r, c in arguments
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==0){
                    row = i;
                    col = j;
                    emptyCellLeft = false;
                    break;
                }
            }
            if(emptyCellLeft==false){
                break;
            }
        }

        if(emptyCellLeft==true){
            return true;//sudoku is solved
        }

        // backtrack
        for(int number = 1; number<=9; number++){
            if(isSafe(board, row, col, number)){
                board[row][col] = number;
                if(solve(board)){
                    // found the answer
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    static void display(int[][] board){
        for(int[] row : board){
            for(int elem : row){
                System.out.print(elem);
            }
            System.out.println();
        }
    }

    static boolean isSafe(int[][] board, int row, int col, int num){
        // check the row -
        for(int i=0; i< board.length; i++){
            if (board[row][i] == num){
                return false;
            }
        }

        // check the col -
        for(int i=0; i< board.length; i++){
            if(board[i][col]==num){
                return false;
            }
        }

        // check the 3x3 box -
        int sqrt = (int) Math.sqrt(board.length);
        int startRow = row - (row%sqrt);
        int startCol = col - (col%sqrt);

        for(int i=startRow; i<startRow+sqrt; i++){
            for(int j=startCol; j<startCol+sqrt; j++){
                if(board[i][j]==num){
                    return false;
                }
            }
        }

        return true;

    }
    public static void main(String[] args){
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 0}
        };
        if(solve(board)){
           display(board);
        } else{
            System.out.println("cant be solved");
        };
    }
}
