package org.example.dsa.trees;

public class BinaryTreeMain {

    public static void main(String[] args){
//        BinaryTree binaryTree = new BinaryTree();
//        Scanner scanner = new Scanner(System.in);
//        binaryTree.populate(scanner);
//
//        binaryTree.prettyDisplay();

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        binarySearchTree.populateSorted(nums);

        binarySearchTree.displayTree();


    }
}
