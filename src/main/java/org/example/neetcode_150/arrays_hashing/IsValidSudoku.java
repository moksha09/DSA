package org.example.neetcode_150.arrays_hashing;

import java.util.HashSet;

public class IsValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();
        // row check -
        for(char[] row: board){
            for(char c: row){
                if(c=='.') continue;
                if(set.contains(c)) return false;
                set.add(c);
            }
            set.clear();
        }


        // column check -
        for(int col=0; col<9; col++){
            for(int row=0; row<9; row++){
                char c = board[row][col];
                if(c=='.')continue;
                if(set.contains(c)) return false;
                set.add(c);
            }
            set.clear();
        }


        // check each box -
        for(int box=0; box<9; box++){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    int row = (box/3)*3 + i;
                    int col = (box%3)*3 + j;
                    if(board[row][col]=='.') continue;
                    if(set.contains(board[row][col])) return false;
                    set.add(board[row][col]);
                }
            }
            set.clear();
        }
        return true;

    }

    public static void main(String[] args){
        char[][] board = {
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board));

    }
}
