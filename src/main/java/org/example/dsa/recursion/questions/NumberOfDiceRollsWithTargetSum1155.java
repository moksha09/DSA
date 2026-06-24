package org.example.dsa.recursion.questions;

import java.util.ArrayList;
import java.util.List;

public class NumberOfDiceRollsWithTargetSum1155 {

    // Some practise problems for bascis -
    //1) Permutations af all sequences from a dice to get a target number
    //eg - target = 4, possible dice outcomes = [1,2,3,4,5,6]
    // result = [4,22,13,31,1111,121,112,211] - these are permutations not combinations

    static List<List<Integer>> permutationDice(List<Integer> p, int up){
        if(up==0){
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>(p));
            return list;
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i=1; i<=up && i<=6; i++ ){
            List<Integer> newList = new ArrayList<>(p);  // copy every time
            newList.add(i);
            result.addAll(permutationDice(newList,up-i));
        }
        return result;

    }

    static void dice(String p, int target){
        if(target==0){
            System.out.println(p);
            return;
        }

        for(int i=1; i<=6 && i<=target; i++){
            dice(p+i, target-i);
        }
    }

    static List<String> diceList(String p, int target){
        if(target==0){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> result = new ArrayList<>();
        for(int i=1; i<=6 && i<=target; i++){
            result.addAll(diceList(p+i, target-i));
        }
        return result;
    }


    // LEETCODE - MEDIUM
    static int numRollsToTarget(int n, int k, int target) {
        return diceRollsToTarget("", n, k, target);
    }

    static int diceRollsToTarget(String p, int n, int k, int target) {
        if (n == 0 && target == 0) return 1;
        if (n == 0 || target < 0) return 0;

        int count = 0;
        for(int j=1; j<=k && j<=target; j++){
            count = count+diceRollsToTarget(p+j, n-1, k, target-j);
        }

        return count;
    }

    public static void main(String[] args){
        System.out.println(numRollsToTarget(2,6,7));
    }

}
