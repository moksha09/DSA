package org.example.dsa.trees.problem.mediumAndHard;

public class ValidateBinarySearchTree {

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

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return checkNodes(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean checkNodes(TreeNode node, long lowerLimit, long upperLimit){
        if(node==null) return true;
        if(lowerLimit>=node.val){
            return false;
        }
        if(upperLimit<=node.val){
            return false;
        }
        return checkNodes(node.left, lowerLimit, node.val) && checkNodes(node.right, node.val, upperLimit);
    }
}
