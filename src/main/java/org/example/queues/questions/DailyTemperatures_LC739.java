package org.example.queues.questions;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures_LC739 {
    public static int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){
            while(!stack.empty() && temperatures[i] > temperatures[stack.peek()]){
                int poppedIndex = stack.pop();
                answer[poppedIndex] = i-poppedIndex;
            }
            stack.push(i);
        }
        return answer;

    }

    public static void main(String[] args){
        int[] input = new int[] {73,74,75,71,69,72,76,73};
        int[] answer = dailyTemperatures(input);
        System.out.println(Arrays.toString(answer));
    }
}
