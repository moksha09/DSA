package org.example.dsa.trees.problem;

public class MaximumDepthOfBinaryTree_LC104 {

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

    // BASICALLY CALCULATE THE HEIGHT OF ROOT
    public int maxDepth(TreeNode root) {
        return height(root);
    }

    public int height(TreeNode node){
        if(node==null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight,rightHeight) + 1;
    }
}
