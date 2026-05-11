package org.example.stacks;

import org.example.stacks.Exception.StackException;

public class StackImplementation {
    // using arrays -
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public StackImplementation(int size) {
        this.data = new int[size];
    }

    public StackImplementation() {
        this(DEFAULT_SIZE);  // CALLING A CONSTRUCTOR USING THIS
    }

    // insert data - increase the ptr & add the item
    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }
        this.ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws Exception {
        if(isEmpty()){
            System.out.println("The stack is empty");
            throw new StackException("Cannot pop from an empty stack");
        }
        int removedItem = data[ptr];
        ptr--;
        return removedItem;
    }

    public int peak() throws Exception {
        if(isEmpty()){
            System.out.println("The stack is empty");
            throw new StackException("The stack is empty");
        }

        return data[ptr];
    }

    public boolean isFull(){
        return ptr == data.length - 1;  // ptr is at last index
    }

    public boolean isEmpty(){
        return ptr == -1;
    }
     
}
