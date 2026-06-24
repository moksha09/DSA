package org.example.dsa.trees.problem;

public class DFS {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int diameter = 0;

    // 542 - Diameter if Binary Tree -
    public int diameterOfBinaryTree(TreeNode root) {

        // LOGIC -
        // For each node we will calculate the diameter passing through that node
        // which would be the sum of left tree height and right tree height.
        // Aat end the max of all the diameters we calculated would be the answer

        if (root==null) return diameter;
        height(root);
        return diameter;

    }

    // to calculate the height of node -
    public int height(TreeNode node){
        if(node==null) return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int dia = leftHeight + rightHeight;
        this.diameter = Math.max(dia, diameter);

        return Math.max(leftHeight, rightHeight)+1;
    }
}
