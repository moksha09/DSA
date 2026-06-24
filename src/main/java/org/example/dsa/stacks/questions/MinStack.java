package org.example.dsa.stacks.questions;

import java.util.List;

public class MinStack {

    private List<Integer> list;

    public MinStack() {

    }

    public void push(int val) {
        list.add(val);
    }

    public void pop() {
        list.removeLast();
    }

    public int top() {
        return list.get(0);
    }

    public int getMin() {
        return -1;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
