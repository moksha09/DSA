package org.example.dsa.trees;

public class SegmentTree {

    private static class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    Node root;

    public SegmentTree(int[] arr){
        // create a tree using this array -
        this.root = constructTree(arr, 0, arr.length-1);
    }

    // Time complexity - O(N) to make tree from array, but O(log(n)) for other operations.
    public Node constructTree(int[] arr, int startIndex, int endIndex) {
        // base condition -
        if (startIndex == endIndex) {
            // we are at the leaf node -
            Node leaf = new Node(startIndex, endIndex);
            leaf.data = arr[startIndex];
            return leaf;
        }

        // create new node with index you are currently at -
        Node node = new Node(startIndex, endIndex);
        int middleIndex = (startIndex+endIndex)/2;

        node.left = constructTree(arr, startIndex, middleIndex);
        node.right = constructTree(arr, middleIndex+1, endIndex);

        node.data = node.left.data + node.right.data;

        return node;
    }

    public void display(){
        display(this.root);
    }
    private void display(Node node){
        String str = "";

        // first display the left node
        if(node.left != null){
            str = str + "Interval = [ " + node.left.startInterval + " - " + node.left.endInterval + " ] and data = " + node.left.data + " => ";
        } else{
            str = str + "No left child";
        }

        // then display the current node -
        str = str + "Interval = [ " + node.startInterval + " - " + node.endInterval + " ] and data = " + node.data + " <= ";

        // then display the right node
        if(node.right != null){
            str = str + "Interval = [ " + node.right.startInterval + " - " + node.right.endInterval + " ] and data = " + node.right.data;
        } else{
            str = str + "No right child";
        }

        // new line and repeat the process -
        System.out.println(str + '\n');

        if(node.left!=null){
            display(node.left);
        }
        if(node.right!=null){
            display(node.right);
        }

    }

    // finding query -
    public int query(int queryStartIndex, int queryEndIndex){
        return this.query(this.root, queryStartIndex, queryEndIndex);
    }

    private int query(Node node, int start, int end){
        if(node.startInterval>=start && node.endInterval<=end){
            // node is lying inside query - take all the items in the node
            return node.data;
        }else if(node.startInterval>end || node.endInterval<start){
            // completely outside the interval
            return 0;
        }else{
            return this.query(node.left, start, end) + this.query(node.right, start, end);
        }
    }

    // update the value -
    public void update(int index, int value){
        this.root.data = update(index, value, root);
    }
    private int update(int index, int value, Node node){
        if(index>= node.startInterval && index<=node.endInterval){
            if(index == node.startInterval && index == node.endInterval){
                // base condition -
                node.data = value;
                return node.data;
            }else{
                int leftAnswer  = update(index, value, node.left);
                int rightAnswer = update(index, value, node.right);
                node.data = leftAnswer + rightAnswer;
                return node.data;
            }
        }else{
            return node.data;
        }
    }

}
