package org.example.dsa.recursion.assignment.easy;

public class RecursiveBubbleSort {

    // BUBBLE SORT - repeatedly swapping 2 elements if its in wrong order-
    // r = num.length-1
    static void recursiveBubbleSort(int[] num,int r,  int c){

        if(r==0){
            return;
        }
        if(c<r){
            if(num[c]>num[c+1]){
                //swap
                int temp = num[c];
                num[c] = num[c+1];
                num[c+1] = temp;
            }
            recursiveBubbleSort(num, r, c+1);
        }else{
            recursiveBubbleSort(num, r-1, 0);
        }

    }

    public static void main(String[] args){

    }
}
