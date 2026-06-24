package org.example.dsa.trees.problem.mediumAndHard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class NumberOfPathsExistsForTheSum {

    // here a path doesn't need to be from root to leaf but can be anything connected.
    // we need find the number of paths whose sum is equal to the given input
    // dfs will be used, backtracking will be used...

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int countPaths(TreeNode node, int sum){
        List<Integer> path = new LinkedList<>();
        return helper(node, sum, path);
    }

    int helper(TreeNode node, int sum, List<Integer> path){
        if(node==null){
            return 0;
        }

        path.add(node.val);
        int count = 0;
        int pathSum = 0;
        // how many paths i can make
        ListIterator<Integer> itr = path.listIterator(path.size());
        while(itr.hasPrevious()){
            pathSum += itr.previous();
            if(pathSum==sum){
                count++;
            }
        }

        count += helper(node.left, sum, path) + helper(node.right, sum, path);
        // backtrack -
        path.remove(path.size()-1);

        return count;
    }

    // same question but put paths in a list -

    List<List<Integer>> findPaths(TreeNode node, int sum){
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper2(node, sum, path, paths);
        return paths;
    }

    void helper2(TreeNode node, int sum, List<Integer> path, List<List<Integer>> paths){
        if(node==null){
            return;
        }

        path.add(node.val);
        if(node.val==sum && node.left==null && node.right==null){
            paths.add(new ArrayList<>(path));
        }else {
            helper2(node.left, sum-node.val, path, paths);
            helper2(node.right, sum-node.val, path, paths);
        }

        // backtrack -
        path.remove(path.size()-1);
    }


}
