package org.example.dsa.trees.problem.mediumAndHard;

public class ConstructBTFromPreOrderAndInOrderTraversal {
    public static class TreeNode {
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

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder==null || inorder==null) return null;
        return createTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);


    }

    public static TreeNode createTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart>preEnd || inStart>inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = getIndex(inorder, root.val);
        int leftSubtreeSize = rootIndex - inStart;

        root.left = createTree(preorder, inorder, preStart+1, preStart + leftSubtreeSize, inStart, rootIndex-1);
        root.right= createTree(preorder, inorder, preStart+leftSubtreeSize+1, preEnd, rootIndex+1, inEnd);

        return root;
    }

    public static int getIndex(int[] arr, int value){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] pre = new int[] {1,2,3};
        int[] in = new int[] {2,3,1};

        System.out.println(buildTree(pre, in).val);
    }
}
