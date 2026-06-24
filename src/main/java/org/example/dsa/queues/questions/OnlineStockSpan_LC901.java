package org.example.dsa.queues.questions;

import java.util.Arrays;
import java.util.Stack;

public class OnlineStockSpan_LC901 {
    /**
     * Design an algorithm that collects daily price quotes for some stock and
     * returns the span of that stock's price for the current day.
     *
     * The span of the stock's price in one day is the maximum number of consecutive days
     * (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.
     *
     * For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2,
     * then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
     * Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8,
     * then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
     *
     * Implement the StockSpanner class:
     *
     * StockSpanner() Initializes the object of the class.
     * int next(int price) Returns the span of the stock's price given that today's price is price.
     */

    Stack<int[]> stack;

    public OnlineStockSpan_LC901() {
        this.stack = new Stack<>();
    }

    public  int next(int price) {
        int[] list = new int[2];
        int span = 1;
        while(!stack.empty() && price>= stack.peek()[0]){
            int[] popped = stack.pop();
            span += popped[1];
        }
        list[0] = price;
        list[1] = span;
        stack.push(list);
        return span;

    }

    // using index to calculate the span -
    public static int[] span(int[] days){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[days.length];

        for(int i=0; i< days.length; i++){
            while(!stack.empty() && days[i] >= days[stack.peek()]){
                stack.pop();
            }
            if(!stack.empty()){
                int span = i - stack.peek();
                ans[i] = span;
            }else{
                int span = i+1;
                ans[i] = span;
            }
            stack.push(i);

        }
        return ans;
    }

    public static void main(String[] args){
        int[] input = new int[] {100, 80, 60, 70, 60, 75, 85};
        int[] answer = span(input);
        System.out.println(Arrays.toString(answer));

    }
}
