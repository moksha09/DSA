package org.example.dsa.trees.problem;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.example.dsa.trees.BinaryTree;

public class BFS extends BinaryTree {

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

    // question 1 - Print in level Order - MEDIUM
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        // initially it will have a root node -
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevelList = new ArrayList<>();
            for(int i=0; i<levelSize; i++){
                TreeNode currentNode = queue.poll();
                currentLevelList.add(currentNode.val);
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }

            result.add(currentLevelList);
        }
        return result;
    }

    // Q2) - Average of levels in Binary tree - EASY
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root==null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            double average = 0.00;
            int currentLevelSize = queue.size();

            for(int i=0; i<currentLevelSize; i++){
                TreeNode currentNode = queue.poll();
                average = average + currentNode.val;

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            average = average/currentLevelSize;
            result.add(average);
        }
        return result;
    }

    // Q3) - Level Order Successor -

    public TreeNode levelOrderSuccessor(TreeNode root, int value){
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for(int i=0; i<levelSize; i++){
                TreeNode currentNode = queue.poll();
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }

                if(currentNode.val == value){
                    return queue.peek();
                }
            }
        }
        return null;
    }

    // Q4) Binary Tree Zigzag Level traversal -

    // USE DEQUE - SO THAT WE CAN ADD OR REMOVE FROM BOTH SIDES -
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Deque<TreeNode> queue = new LinkedList<>();
        // initially it will have a root node -
        queue.offer(root);
        int level = 0;

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevelList = new ArrayList<>();

                for(int i=0; i<levelSize; i++){
                    if(level%2==0){
                        TreeNode currentNode = queue.pollFirst();
                        currentLevelList.add(currentNode.val);
                        if(currentNode.left!=null){
                            queue.offerLast(currentNode.left);
                        }
                        if(currentNode.right!=null){
                            queue.offerLast(currentNode.right);
                        }
                    }else{
                        TreeNode currentNode = queue.pollLast();
                        currentLevelList.add(currentNode.val);
                        if(currentNode.right!=null){
                            queue.offerFirst(currentNode.right);
                        }
                        if(currentNode.left!=null){
                            queue.offerFirst(currentNode.left);
                        }
                    }
                }
            result.add(currentLevelList);
            level++;
        }
        return result;
    }

    // Q5) Level Order Bottom -
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        // initially it will have a root node -
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevelList = new ArrayList<>();
            for(int i=0; i<levelSize; i++){
                TreeNode currentNode = queue.poll();
                currentLevelList.add(currentNode.val);
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }

            result.add(0,currentLevelList);
        }
        return result;
    }


}
