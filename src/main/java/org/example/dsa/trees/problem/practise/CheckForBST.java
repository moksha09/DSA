package org.example.dsa.trees.problem.practise;

/**
 * Given the root of a binary tree, determine whether it is a Binary Search Tree (BST).
 *
 * A Binary Search Tree is a binary tree that satisfies the following conditions:
 *
 * All nodes in the left subtree have values smaller than the root.
 * All nodes in the right subtree have values greater than the root.
 * Both left and right subtrees are themselves BSTs.
 * All node values are distinct.
 */

public class CheckForBST {

    public static class Node {
        int data;
        Node left, right;
        Node(int d)
        {
            data  =d;
            left = right = null;
        }
    }


    public static boolean isBST(Node root) {
        if(root==null) return true;
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    public static boolean helper(Node root, int min, int max){
        if(root==null) return true;
        return (root.data > min && root.data < max) && helper(root.left, min, root.data) && helper(root.right, root.data, max);
    }

    public static void main(String[] args){
        Node root = new Node(10);
        Node l1 = new Node(5);
        Node r1 = new Node(20);
        Node l2 = new Node(4);
        Node r2 = new Node(6);
        Node l3 = new Node(16);
        Node r3 = new Node(25);

        root.left = l1;
        root.right = r1;
        l1.left = l2;
        l1.right = r2;
        r1.left = l3;
        r1.right = r3;

        System.out.println(isBST(root));
    }
}
