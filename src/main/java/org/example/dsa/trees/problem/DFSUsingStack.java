package org.example.dsa.trees.problem;

import java.util.Stack;

public class DFSUsingStack {

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

    // pre-order -
    void dfsStack(TreeNode node){
        if (node==null)return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){
            TreeNode nodeRemoved = stack.pop();
            System.out.print(nodeRemoved + "  ");

            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
    }
}
