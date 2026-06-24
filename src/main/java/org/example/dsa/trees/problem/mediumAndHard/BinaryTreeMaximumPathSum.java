package org.example.dsa.trees.problem.mediumAndHard;

public class BinaryTreeMaximumPathSum {

    // HARD
    public static class TreeNode {
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

    int globalBestAnswer = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        maxSum(root);
        return globalBestAnswer;
    }

    public int maxSum(TreeNode node){
        if(node==null) return 0;

        // Ignore negative contributions
        int left = Math.max(0, maxSum(node.left));
        int right = Math.max(0, maxSum(node.right));

        int bestCurrentPathSum = node.val + left + right;
        // Update global answer
        globalBestAnswer = Math.max(globalBestAnswer, bestCurrentPathSum);
        return node.val + Math.max(left, right);
    }
}
