package org.example.dsa.range_query;

import java.util.Arrays;

public class SquareRootDecomposition {

    // SQUARE ROOT DECOMPOSITION - MO'S ALGORITHM

    public static int query(int[] blocks, int[] arr, int l, int r, int sqrt){
        int ans = 0;
        // left part -
        while(l%sqrt != 0 && l<r && l!=0){
            ans += arr[l];
            l++;
        }
        // middle -
        while (l+sqrt <= r){
            ans += blocks[l/sqrt];
            l += sqrt;
        }
        // right -
        while(l<=r){
            ans += arr[l];
            l++;
        }
        return ans;
    }

    public static void update(int[] blocks, int[] arr, int i, int newValue, int sqrt){
        int block_id = i/sqrt;
        blocks[block_id] += (newValue - arr[i]);
        arr[i] = newValue;
        return;
    }

    public static void main(String[] args){
        int[] arr = {1, 3, 5, 2, 7, 6, 3, 1, 4, 8};
        int n = arr.length;

        // build a block array -
        int sqrt = (int) Math.sqrt(n);

        int blocks_id = -1;

        int[] blocks = new int[sqrt + 1];

        for(int i=0; i<n; i++){
            if( i%sqrt==0 ){
                // new block is starting -
                blocks_id++;
            }
            blocks[blocks_id] += arr[i];
        }

        System.out.println(Arrays.toString(blocks));
        System.out.println(query(blocks, arr, 2, 7, sqrt));
        update(blocks, arr, 4, 8, sqrt);
        System.out.println(Arrays.toString(blocks));
        System.out.println(query(blocks, arr, 2, 7, sqrt));


    }
}
