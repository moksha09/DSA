package org.example.dsa.trees.problem;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree_LC101 {

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

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        return (left.val == right.val) && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    // using queue (BFS) -
    public static boolean isSymmetricBFS(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()){
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();

            if(leftNode == null && rightNode == null){
                continue;
            }
            if(leftNode == null || rightNode == null){
                return false;
            }
            if(leftNode.val != rightNode.val){
                return false;
            }

            queue.add(leftNode.left);
            queue.add(rightNode.right);
            queue.add(leftNode.right);
            queue.add(rightNode.left);
        }
        return true;

    }



    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(2);

        TreeNode l1l1 = new TreeNode(3);
        TreeNode l1r1 = new TreeNode(4);

        TreeNode r1l1 = new TreeNode(4);
        TreeNode r1r1 = new TreeNode(3);

        root.left = l1;
        root.right = r1;

        l1.left = l1l1;
        l1.right = l1r1;

        r1.left = r1l1;
        r1.right = r1r1;

        System.out.println(isSymmetricBFS(root));



    }


}
