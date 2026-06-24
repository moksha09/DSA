package org.example.dsa.queues.questions;

import java.util.Stack;

public class LargestRectangleInHistogram_LC84 {

    // LC - HARD -

    // brute force - O(N^3)
    public int largestRectangleArea1(int[] heights) {

        int maxArea = 0;

        for(int i=0; i<heights.length; i++){
            int leftIndex = i-1;
            while(leftIndex>=0){
                if(heights[leftIndex]>=heights[i]){
                    leftIndex--;
                }else{
                    break;
                }
            }

            int rightIndex = i+1;
            while(rightIndex<heights.length){
                if(heights[rightIndex]>=heights[i]){
                    rightIndex++;
                }else{
                    break;
                }
            }

            int width = rightIndex-leftIndex-1;
            maxArea = Math.max(maxArea,width*heights[i]);
        }

        return maxArea;
    }

    // optimized solution using stacks - [2,1,5,6,2,3]
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int i=0; i< heights.length; i++){
            while(!stack.empty() && heights[i]<heights[stack.peek()]){
                // calculate the area here itself -
                int poppedIndex = stack.pop();
                if(stack.empty()){
                    maxArea = Math.max(maxArea, heights[poppedIndex] * i);
                }else{
                    maxArea = Math.max(maxArea, (heights[poppedIndex] * (i-1-stack.peek())));
                }
            }
            stack.push(i);
        }

        int i = heights.length;
        while(!stack.empty()){
            int poppedIndex = stack.pop();
            if(stack.empty()){
                maxArea = Math.max(maxArea, heights[poppedIndex] * i);
            }else{
                maxArea = Math.max(maxArea, (heights[poppedIndex] * (i-1-stack.peek())));
            }
        }

        return maxArea;
    }
}
