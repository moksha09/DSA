package org.example.dsa.trees.problem.practise;

public class LowestCommonAncestor {

    /**
     * Given the root of a Binary Tree with unique values and
     * two node values n1 and n2, find the Lowest Common Ancestor (LCA).
     * LCA is the deepest node that has both n1 and n2 as descendants.
     *
     * Note: Both node values are always present in the Binary Tree.
     */
    public static class Node {
        int data;
        Node left, right;
        Node(int d)
        {
            data  =d;
            left = right = null;
        }
    }

    // Used Post order DFS - Check if the n1 or n2 exist in left side or right side if it does return that node
    // for a node - of its left and right subtree return non null value that means its the least common ancestor
    // TC = O(n)
    Node lca(Node root, int n1, int n2) {
        return helper(root, n1, n2);

    }

    Node helper(Node root, int n1, int n2){
        if(root==null) return null;
        if(root.data == n1 || root.data == n2) return root;

        Node left = helper(root.left, n1, n2);
        Node right = helper(root.right, n1, n2);

        if(left!=null && right!=null) return root;

        if(left==null){
            return right;
        }else{
            return left;
        }
    }

}
