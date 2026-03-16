package org.example.recursion.backtracking.exercise;

public class NKnightsProblem {

    static int nKnights(boolean[][] board, int row, int col, int target){
        // base case -
        if(target==0){
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        if(col == board.length){
             return nKnights(board, row+1, 0, target);
        }

        if(row == board.length){
            return 0;
        }

        // checking each column -
        if(isSafe(board, row, col)){
            board[row][col] = true;
            count = count + nKnights(board, row, col+1, target-1);
            board[row][col] = false;
        }

        count = count + nKnights(board, row, col+1, target);

        return count;


    }

    static void display(boolean[][] board){
        for(boolean[] row : board){
            for(boolean elem: row){
                if(elem){
                    System.out.print("K");
                }else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    static boolean isSafe(boolean[][] board, int r, int c){
        // check below twice{
        if((r-1)>=0 && (c+2)<board.length){
            if(board[r-1][c+2]){
                return false;
            }
        }
        if((r-1)>=0 && (c-2)>=0){
            if(board[r-1][c-2]){
                return false;
            }
        }
        if((r-2)>=0 && (c+1)< board.length){
            if(board[r-2][c+1]){
                return false;
            }
        }

        if((r-2)>=0 && (c-1)>= 0){
            if(board[r-2][c-1]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        boolean[][] board = new boolean[3][3];
        System.out.println(nKnights(board, 0, 0, 5));

    }
}
