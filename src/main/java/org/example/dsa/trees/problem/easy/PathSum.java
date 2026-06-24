package org.example.dsa.trees.problem.easy;

public class PathSum {
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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        return helper(root, targetSum);

    }

    public boolean helper(TreeNode node, int targetSum){
        if(node==null) return false;
        targetSum = targetSum-node.val;
        if(node.left==null && node.right == null){
            if(targetSum == 0){
                return true;
            }
        }
        return helper(node.left, targetSum) || helper(node.right, targetSum);
    }
}
