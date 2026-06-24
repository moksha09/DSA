package org.example.dsa.trees.problem;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree_LC993 {

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
    public boolean isCousinsBrute(TreeNode root, int x, int y) {
        return getLevel(root, x) == getLevel(root, y) && getParent(root, x) != getParent(root, y);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        if(x == root.val || y == root.val) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            boolean foundX = false;
            boolean foundY = false;
            int parentX = x;
            int parentY = y;

            // iterate through all nodes of the level -
            for(int i=0; i<levelSize; i++){
                TreeNode currentNode = queue.poll();

                if(currentNode.left!=null){
                    if(currentNode.left.val == x){
                        parentX = currentNode.val;
                        foundX = true;
                    } else if (currentNode.left.val == y) {
                        parentY = currentNode.val;
                        foundY = true;
                    }
                    queue.offer(currentNode.left);
                }

                if(currentNode.right!= null){
                    if(currentNode.right.val == x){
                        parentX = currentNode.val;
                        foundX = true;
                    }else if (currentNode.right.val == y) {
                        parentY = currentNode.val;
                        foundY = true;
                    }
                    queue.offer(currentNode.right);
                }
            }
            if(parentX!=parentY && foundX && foundY){
                return true;
            }

        }
        return false;
    }

    public int getLevel(TreeNode root, int x){
        if(x == root.val){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i=0; i<levelSize; i++){
                TreeNode currentNode = queue.poll();
                if(currentNode.val==x){
                    return level;
                }
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
            level++;
        }
        return -1;
    }

    public int getParent(TreeNode root, int x){
        if(x==root.val) return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for(int i=0; i<levelSize; i++){
                TreeNode currentNode = queue.poll();

                if(currentNode.left!=null){
                    if(currentNode.left.val == x){
                        return currentNode.val;
                    }
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    if(currentNode.right.val == x){
                        return currentNode.val;
                    }
                    queue.offer(currentNode.right);
                }
            }
        }
        return -1;
    }
}
