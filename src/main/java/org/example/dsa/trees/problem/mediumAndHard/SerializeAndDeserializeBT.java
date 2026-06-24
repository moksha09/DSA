package org.example.dsa.trees.problem.mediumAndHard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SerializeAndDeserializeBT {

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

    public List<String> serialization(TreeNode node){
        List<String> list = new ArrayList<>();
        helper(node, list);
        return list;
    }
    public void helper(TreeNode node, List<String> strings){
        if(node == null){
            strings.add("n");
            return;
        }
        strings.add(String.valueOf(node.val));
        helper(node.left, strings);
        helper(node.right, strings);
    }

    public TreeNode deserialize(List<String> string){
        // reverse the list for efficiency - If we remove the first element from the list - everytime it will have to shift all the element one side right.
        // so to make it more efficient we can reverse the list and remove from last so that no extra traversal is required
        List<String> newList = new ArrayList<>(string); // create a new list since the input list is of static size - only get and set methods are allowed in it
        Collections.reverse(newList);
        TreeNode node = helper2(newList);
        return node;
    }

    public TreeNode helper2(List<String> list) {
        String value = list.remove(list.size()-1);
        if (value.equals("n")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = helper2(list);
        node.right = helper2(list);
        return node;

    }

    // Encodes a tree to a single string.
    // Store the node in pre-order with nulls - root -> left -> right
    public String serialize(TreeNode root) {
        List<String> list = serialization(root);
        return String.join(",", list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] list = data.split(",");
        return deserialize(Arrays.asList(list));  // Arrays.list gives you an unmodifiable list to work with
    }

}
