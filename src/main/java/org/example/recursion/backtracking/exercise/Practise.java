package org.example.recursion.backtracking.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practise {

    // 1) place 'k' knights on n x m board -
    static int nKnights(boolean[][] board, int row, int col, int target){
        // base condition
        if(target==0){
            display(board);
            System.out.println();
            return 1;
        }

        if(row==board.length){
            return 0;
        }

        if(col == board.length){
            return nKnights(board, row+1, 0, target);
        }

        int count = 0;
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
        if((r-1)>=0 && (c+2)<board[0].length){
            if(board[r-1][c+2]){
                return false;
            }
        }
        if((r-1)>=0 && (c-2)>=0){
            if(board[r-1][c-2]){
                return false;
            }
        }
        if((r-2)>=0 && (c+1)< board[0].length){
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



    // 2) Generate all subsets of {1,2,3} - {1}, {2}, {3}, {1,2}, {1,2,3}, {2,3}, {1,3}

    // pattern take an element -> we then have 2 choices either take the element or ignore the element
    // will use processed and unprocessed approach


    static void mainSubset(int[] arr){
        listSubset(arr, 0, new ArrayList<>());
    }

    // in processed unprocessed when working with arrays you have to know that arrays are passed by reference to functions
    // so during recursive calls rather than passing a new copy copy of that array we are passing a reference to the same array
    // in processed since we do changes to the processed array its very important to undo those changes so that we call the
    // rhs (ignore element) part.
    // also strings are dynamic in sizes but arrays ar not hence we can use an index to separate the part which is resolved or processed
    // and the part which is not processed
    static void listSubset(int[] arr, int index, List<Integer> processed){
        if(index==arr.length){
            System.out.println(processed);
            return;
        }

        // take it -
        processed.add(arr[index]);
        listSubset(arr, index+1, processed);
        //backtrack -
        processed.remove(processed.size()-1);

        //ignore it -
        listSubset(arr, index+1, processed);
    }


    // using strings
    static void subset(String p, String up){
        // base case -
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        // take it -
        subset(p+ch, up.substring(1));
        //ignore it -
        subset(p,up.substring(1));
    }

    // now lets to solve this using iterations -
    static List<List<Integer>> mainSubset2(int[] arr){

        List<List<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>());

        for(int num : arr){
            int n = outerList.size();
            for(int i=0; i<n; i++){
                List<Integer> innerList = new ArrayList<>(outerList.get(i));
                innerList.add(num);
                outerList.add(innerList);
            }
        }
        return outerList;
    }


    public static void main(String[] args){
        boolean[][] board = new boolean[2][3];
        //System.out.println(nKnights(board, 0, 0, 2));

        int[] arr = new int[] {1,2,3};
        mainSubset(arr);

    }


}
