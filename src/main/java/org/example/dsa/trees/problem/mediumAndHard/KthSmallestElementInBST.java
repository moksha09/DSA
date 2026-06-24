package org.example.dsa.trees.problem.mediumAndHard;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {

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

    // Brute force - convert it into a sorted array and get the kth element
    public static int kthSmallestBrute(TreeNode root, int k) {
        dfsBrute(root);
        return list.get(k-1);

    }

    public static int kthSmallest(TreeNode root, int k) {
        return dfs(root, k).val;

    }

    public static List<Integer> list = new ArrayList<>();
    public static int count = 0;
    public static TreeNode dfsBrute(TreeNode node){
        if(node==null) {
            return null;
        }
        dfsBrute(node.left);
        list.add(node.val);
        count++;
        dfsBrute(node.right);

        return node;
    }

    public static TreeNode dfs(TreeNode node, int k){
        if(node == null) return null;

        TreeNode left = dfs(node.left, k);
        if(left!=null){
            return left;
        }
        count++;
        if(count==k){
            return node;
        }
        return dfs(node.right, k);
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(5);
        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(6);

        TreeNode left2 = new TreeNode(2);
        TreeNode right2 = new TreeNode(4);

        TreeNode left3 = new TreeNode(1);

        root.left = left1;
        root.right = right1;

        left1.left = left2;
        left1.right = right2;

        left2.left = left3;


        System.out.println(kthSmallest(root, 3));
        System.out.println(list);

    }
}
