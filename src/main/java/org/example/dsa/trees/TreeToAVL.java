package org.example.dsa.trees;

public class TreeToAVL {
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

    public TreeToAVL(){

    }

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public int height(){
        return height(root);
    }

    public boolean isEmpty(){
        return root==null;
    }

    public void display(){
        display(root, "Root Node: ");
    }

    private void display(Node node, String details){
        if(node==null){
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
        return rotate(node);
    }

    public Node rotate(Node node){

        // Unbalanced and Left Heavy
        if(height(node.left)-height(node.right) > 1){
            if(height(node.left.left)-height(node.left.right) > 0){
                // left-left case
                return rightRotate(node);
            }

            if(height(node.left.left)-height(node.left.right) < 0){
                // left-right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        // Unbalanced and Right Heavy
        if(height(node.left)-height(node.right) < -1){
            if(height(node.right.right)-height(node.right.left) > 0){
                // right-right case
                return leftRotate(node);
            }

            if(height(node.right.right)-height(node.right.left) < 0){
                // right-left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    public Node leftRotate(Node p){
        Node c = p.right;
        Node t = c.left;

        p.right = t;
        c.left = p;

        p.height = Math.max(height(p.left), height(p.right))+1;
        c.height = Math.max(height(c.left), height(c.right))+1;
        return c;
    }

    public Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;

        p.left = t;
        c.right = p;

        p.height = Math.max(height(p.left), height(p.right))+1;
        c.height = Math.max(height(c.left), height(c.right))+1;
        return c;
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
