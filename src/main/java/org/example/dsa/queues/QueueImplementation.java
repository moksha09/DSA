package org.example.dsa.queues;

public class QueueImplementation {
    private int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = 0;  // here lets say the ptr is pointing towards the last element

    public QueueImplementation(){
        this(DEFAULT_SIZE);
    }
    public QueueImplementation(int size){
        this.data = new int[size];
    }

    public boolean isFull(){
        return ptr == data.length; // ptr is at the last index
    }

    public boolean isEmpty(){
        return ptr == 0;
    }

    // Time complexity - O(1)
    public boolean insert(int item){
        if(isFull()){
            System.out.println("Queue is full");
            return false;
        }
        data[ptr] = item;
        ptr++;
        return true;
    }

    // Time Complexity = O(n)
    public int remove(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int removedItem = data[0];

        for(int i=1; i< ptr; i++){
            data[i-1] = data[i];
        }
        ptr--;
        return removedItem;
    }

    public int front(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return data[0];
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        }
        for(int i=0; i<ptr; i++){
            System.out.println(data[i] + " ");
        }
        System.out.println("END");
    }
}
