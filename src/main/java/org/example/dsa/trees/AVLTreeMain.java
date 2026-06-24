package org.example.dsa.trees;

public class AVLTreeMain {

    public static void main(String[] args){
        TreeToAVL avl  = new TreeToAVL();

        // creating an unbalanced tree -
        for(int i=0; i<1000; i++){
            avl.insert(i);
        }

        System.out.println(avl.height()); // => 2^9 ~ 1000
    }
}
