package org.example.dsa.trees.problem.easy;

public class PathExists {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean findPath(TreeNode node, int[] arr){
        if(node==null) return (arr.length==0);
        return helper(node, arr, 0);

    }

    public static boolean helper(TreeNode node, int[] arr, int i){
        if(node==null) return false;
        if(i>=arr.length || node.val!=arr[i]){
            return false;
        }
        if(node.left==null && node.right==null && i == arr.length-1){
            return true;
        }
        return helper(node.left, arr, i+1) || helper(node.right, arr, i+1);
    }

    //
}
