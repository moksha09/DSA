package org.example.queues.questions;

import java.util.Arrays;

public class GameOfTwoStacks_HackerRank {
    /**
     * Alexa has two stacks of non-negative integers, stack a[n] and stack b[m] where index 0 denotes the top of the stack.
     * Alexa challenges Nick to play the following game:
     *
     * In each move, Nick can remove one integer from the top of either stack a or stack b.
     * Nick keeps a running sum of the integers he removes from the two stacks.
     * Nick is disqualified from the game if, at any point, his running sum becomes greater than some integer maxSum
     * given at the beginning of the game.
     * Nick's final score is the total number of integers he has removed from the two stacks.
     * Given a,b and maxSum for g games, find the maximum possible score Nick can achieve.
     */

    // this is like recursion - subsequence problem -

    public static int twoStackGame(int maxSum, int[] a, int[] b){
        // here we are doing -1, because count is increased after the base in condition is met at end , hence for final
        // answer we reduce it by 1;
        return twoStackGame(maxSum, a, b, 0, 0) - 1;
    }

    private static int twoStackGame(int maxSum, int[] a, int[] b, int currentSum, int count){

        if(currentSum>maxSum){
            return count;
        }
        if(a.length==0 || b.length==0){
            return count;
        }
        // we have 2 options here - either take the top element from first stack or from the second stack -
        int left = twoStackGame(maxSum, Arrays.copyOfRange(a,1,a.length), b, currentSum+a[0], count+1 );
        int right = twoStackGame(maxSum, a, Arrays.copyOfRange(b,1,b.length), currentSum+b[0], count+1);
        return Math.max(left, right);

    }

    public static void main(String[] args){
        int[] a = new int[] {4,2,4,6,1};
        int[] b = new int[] {2,1,8,5};
        int maxSum = 10;

        System.out.println("answer - " + twoStackGame(maxSum, a, b));
    }


}
