package org.example.dsa.sorting.problems.assignment.easy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeightChecker1051 {

    /**
     * 1051 - Height Checker -
     * A school is trying to take an annual photo of all the students.
     * The students are asked to stand in a single file line in non-decreasing order by height.
     * Let this ordering be represented by the integer array expected where expected[i] is the
     * expected height of the ith student in line.
     * You are given an integer array heights representing the current order that the students
     * are standing in. Each heights[i] is the height of the ith student in line (0-indexed).
     * Return the number of indices where heights[i] != expected[i].
     *
     * Example 1:
     * Input: heights = [1,1,4,2,1,3]
     * Output: 3
     * Explanation:
     * heights:  [1,1,4,2,1,3]
     * expected: [1,1,1,2,3,4]
     * Indices 2, 4, and 5 do not match.
     *
     * Example 2:
     * Input: heights = [5,1,2,3,4]
     * Output: 5
     * Explanation:
     * heights:  [5,1,2,3,4]
     * expected: [1,2,3,4,5]
     * All indices do not match.
     * @param heights
     * @return
     */
    static int heightChecker(int[] heights) {

        int[] original = Arrays.copyOf(heights, heights.length);
        int result = 0;
        Arrays.sort(heights);

        for(int i=0; i<heights.length;i++){
            if(original[i]!=heights[i]){
                result++;
            }
        }
        return result;

    }

    // Using Priority Queue -
    static int heightChecker2(int[] heights) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int height :heights){
            queue.add(height);
        }
        int reulst = 0;
        for(int i=0; i<heights.length; i++){
            if(heights[i] != queue.poll()){
                reulst++;
            }
        }
        return reulst;

    }


    public static void main(String[] args){

    }
}
