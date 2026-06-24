package org.example.dsa.trees.problem.mediumAndHard;

public class SumRootToGivenNumber {

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

    public static int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public static int helper(TreeNode node, int sum){
        if(node==null) return 0;
        int currentSum = sum*10 + node.val;
        if(node.left == null && node.right==null){
            return currentSum;
        }

        int left = helper(node.left, currentSum);
        int right = helper(node.right, currentSum);
        return left+right;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(sumNumbers(root));
    }
}
