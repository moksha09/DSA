package org.example.dsa.trees.problem.mediumAndHard;

import java.util.LinkedList;
import java.util.Queue;

public class FlattenBinaryTreeToLinkedList {

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

    // BRUTE FORCE - Time complexity - O(N) nad space - O(N)
    Queue<TreeNode> queue = new LinkedList<>();
    public void flattenBruteForce(TreeNode root) {
        if(root == null) return;
        preOrder(root);
        createTree(queue, root);
    }

    // Put the nodes in queue in pre-order -
    public void preOrder(TreeNode node){
        if(node == null) return;
        queue.offer(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    // Create a skewed tree from the queue -
    public void createTree(Queue<TreeNode> queue, TreeNode currentNode){
        if(currentNode==null) return;
        currentNode.right = queue.poll();
        currentNode.left = null;
        createTree(queue, currentNode.right);
    }

    // Optimized - without using any extra space - Space Complexity - O(1)

    // Logic -
    public void flatten(TreeNode root) {
        if(root==null) return;
        TreeNode temp = root;
        while(temp!=null){
            TreeNode left = temp.left;
            if(left!=null){
                TreeNode rightMostElement = left;
                while(rightMostElement.right!=null){
                    rightMostElement = rightMostElement.right;
                }
                rightMostElement.right = temp.right;
                temp.right = left;
                temp.left = null;
            }
            temp = temp.right;
        }
    }

}
