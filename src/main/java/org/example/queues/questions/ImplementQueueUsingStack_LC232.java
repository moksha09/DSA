package org.example.queues.questions;

import java.util.Stack;

public class ImplementQueueUsingStack_LC232 {

    /**
     * Implement a first in first out (FIFO) queue using only two stacks.
     * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
     *
     * Implement the MyQueue class:
     *
     * void push(int x) Pushes element x to the back of the queue.
     * int pop() Removes the element from the front of the queue and returns it.
     * int peek() Returns the element at the front of the queue.
     * boolean empty() Returns true if the queue is empty, false otherwise.
     */
    private Stack<Integer> firstStack;
    private Stack<Integer> secondStack;

    public ImplementQueueUsingStack_LC232() {
        this.firstStack = new Stack<>();
        this.secondStack = new Stack<>();
    }

    // I have implemented a insert efficient queue - you can also implement a remove efficient queue
    public void push(int x) {
        this.firstStack.push(x);
    }

    public int pop() {
        // shift the items to second stack -
        while(!firstStack.empty()){
            secondStack.push(firstStack.pop());
        }
        // pop from the 2nd stack -
        int removedItem = secondStack.pop();;

        // move the elements back tot first stack -
        while(!secondStack.empty()){
            firstStack.push(secondStack.pop());
        }

        return removedItem;
    }

    public int peek() {
        while(!firstStack.empty()){
            secondStack.push(firstStack.pop());
        }
        // peek first element from stack -
        int firstElem =  secondStack.peek();

        // move the elements back tot first stack -
        while(!secondStack.empty()){
            firstStack.push(secondStack.pop());
        }
        return firstElem;
    }

    public boolean empty() {
        return firstStack.empty();
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
}
