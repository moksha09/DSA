package org.example.trees;

public class BinarySearchTree {
    public class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }
    }

    private Node root;

    public BinarySearchTree(){

    }

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root==null;
    }

    public void display(){
        display(root, "Root Node: ");
    }

    private void display(Node node, String details){
        if(root==null){
            return;
        }
        System.out.println(details + node.getValue());

        // right -
        display(node.left, "Left child of: " + node.getValue() + " : ");
        display(node.right, "Right child of: " + node.getValue() + " : ");
    }

    public void insert(int value){
        root =  insert(value, root);
    }
    private Node insert(int value, Node node){
        if(node == null){
            return new Node(value);
        }
        if(value<node.getValue()){
            node.left = insert(value, node.left);
        }else {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right))+1;
        return node;
    }

    // function to check whether the tree is balanced or not -
    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node){
        if(node==null) return true;

        return Math.abs(height(node.left)-height(node.right))<=1 &&
                isBalanced(node.left) && isBalanced(node.right);
    }

    public void displayTree(){
        displayTree(root, "Root node - ");
    }
    private void displayTree(Node node, String details){
        if(node==null) return;

        System.out.println(details + node.value);

        // left -
        displayTree(node.left, "Left of - " + node.value + " is - ");
        // right -
        displayTree(node.right, "Right of - " + node.value + " is - ");
    }

    public void populate(int[] nums){
        for(int i=0; i< nums.length; i++){
            this.insert(nums[i]);
        }
    }

    public void populateSorted(int[] nums) {
        populateSorted(nums, 0, nums.length-1);
    }

    private void populateSorted(int[] nums, int start, int end){
        if(start>=end){
            return;
        }
            int middle = (start+end)/2;
            insert(nums[middle]);
            populateSorted(nums, start, middle);
            populateSorted(nums, middle+1, end);
    }


}
