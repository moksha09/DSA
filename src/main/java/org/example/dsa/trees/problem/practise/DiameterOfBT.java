package org.example.dsa.trees.problem.practise;

public class DiameterOfBT {
    /**
     * Given the root of a binary tree, your task is to find the diameter
     * of the binary tree. The diameter of a binary tree is defined as the
     * number of edges on the longest path between any two nodes.
     *
     * Note that this path may or may not pass through the root of the tree.
     */


    public static class Node {
        int data;
        Node left, right;
        Node(int d)
        {
            data  =d;
            left = right = null;
        }
    }

    int diameter = 0;

    // Brute force - for each node calculate the diameter = height(node.left) + height(node.right) + 1; and return the max.
    // TC = o(n*n)
    // Optimized TC = O(n)
    public int diameter(Node root) {
        height(root);
        return diameter;
    }
    public int height(Node root){
        if(root==null) return 0;
        int heightLeft = height(root.left);
        int heightRight = height(root.right);

        this.diameter = Math.max(diameter, (heightLeft + heightRight));
        return Math.max(heightLeft, heightRight) + 1;
    }
}
