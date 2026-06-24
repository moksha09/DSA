package org.example.dsa.recursion.assignment.medium;

public class WordSearch {

    /**
     * Given an m x n grid of characters board and a string word,
     * return true if word exists in the grid.
     *
     * The word can be constructed from letters of sequentially adjacent cells,
     * where adjacent cells are horizontally or vertically neighboring.
     * The same letter cell may not be used more than once.
     */

    static boolean exist(char[][] board, String word){
        int row = board.length;
        int col = board[0].length;
        boolean[][] path = new boolean[row][col];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(existHelper(board, path, i, j, word.toCharArray(), 0)){
                    return true;
                }
            }
        }
        return false;

    }

    static boolean existHelper(char[][] board, boolean[][] path, int r, int c,  char[] word, int index){
        // base case -
        if(index == word.length){
            return true;
        }

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return false;
        }
        char current = board[r][c];

        if(current!=word[index]){
            return false;
        }

        if(path[r][c]){
            return false;
        }

        path[r][c] = true;
        boolean found = (existHelper(board, path, r, c+1, word,index+1)) ||
                (existHelper(board, path, r+1, c, word,index+1)) ||
                (existHelper(board, path, r, c-1, word,index+1)) ||
                (existHelper(board, path, r-1, c, word,index+1));

        path[r][c] = false;
        return found;
    }

    public static void main(String[] args){
        char[][] board = {
                {'A', 'B', 'C', 'D'},
                { 'L', 'M', 'O', 'F'},
                { 'N', 'D', 'O', 'M'}
        };

        char[][] board1 = {
                {'A'}
        };

        System.out.println(exist(board, "ABCOOL"));
        System.out.println(exist(board1, "A"));
    }
}
