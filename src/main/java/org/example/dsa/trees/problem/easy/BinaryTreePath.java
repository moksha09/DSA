package org.example.dsa.trees.problem.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {

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

    static List<String> result = new ArrayList<>();

    public static List<String> binaryTreePaths(TreeNode root) {
        helper(root, "");
        return result;
    }

    public static String helper(TreeNode node, String str){
        if(node==null){
            return "";
        }
        str = str + node.val;

        if(node.left!=null){
            helper(node.left, str + "->");
        }
        if(node.right!=null){
            helper(node.right, str + "->");
        }
        if(node.left==null && node.right==null){
            result.add(str);
            return "";
        }

        return str;
    }

    // Path Exists in a binary tree from root to leaf =
    public static boolean pathExist(TreeNode root, String str){
        binaryTreePaths(root);
        return (result.contains(str));
    }



    public static void main(String[] args){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        //System.out.println(binaryTreePaths(root));

        // path exists =
        System.out.println(pathExist(root, "1->2->5"));
    }
}
