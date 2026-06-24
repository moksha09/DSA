package org.example.dsa.trees.problem;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers_LC116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    // MY APPROACH - Takes O(N) space complexity
    public Node connectBrute(Node root) {
        if(root==null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i=0; i< levelSize; i++){
                Node currentNode = queue.poll();
                if(i==(Math.pow(2, level)-1)){
                    currentNode.next = null;
                }else{
                    currentNode.next = queue.peek();
                }
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            level++;
        }

        return root;
    }

    // How to do it with constant extra space - O(1)
    // TODO - Revise this question again -
    public Node connect(Node root){
        if(root == null) return root;

        Node currentNode = root;
        while(currentNode.left!=null){
            Node temp = currentNode;

            while(currentNode!=null){
                currentNode.left.next = currentNode.right;
                currentNode.right.next = currentNode.next == null ? null : currentNode.next.left;
                currentNode = currentNode.next;
            }
            currentNode = temp.left;
        }
        return root;
    }


}
