package org.example.dsa.trees.problem.practise;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class ZigZagTraversal {

    public static class Node {
        int data;
        Node left, right;
        Node(int d)
        {
            data  =d;
            left = right = null;
        }
    }

    public static ArrayList<Integer> zigZagTraversal(Node root){
        ArrayList<Integer> result = new ArrayList<>();
        if(root==null) return result;

        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i=0; i<levelSize; i++){
                if(level%2==0){
                    Node currentNode = queue.pollFirst();
                    result.add(currentNode.data);
                    if(currentNode.left!=null){
                        queue.offerLast(currentNode.left);
                    }
                    if(currentNode.right!=null){
                        queue.offerLast(currentNode.right);
                    }
                }else{
                    Node currentNode = queue.pollLast();
                    result.add(currentNode.data);
                    if(currentNode.right!=null){
                        queue.offerFirst(currentNode.right);
                    }
                    if(currentNode.left!=null){
                        queue.offerFirst(currentNode.left);
                    }
                }
            }
            level++;
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args){
        Node root = new Node(1);
        Node l1 = new Node(2);
        Node r1 = new Node(3);
        Node l2 = new Node(4);
        Node r2 = new Node(5);
        Node l3 = new Node(6);
        Node r3 = new Node(7);

        root.left = l1;
        root.right = r1;
        l1.left = l2;
        l1.right = r2;
        r1.left = l3;
        r1.right = r3;

        zigZagTraversal(root);
    }

}
