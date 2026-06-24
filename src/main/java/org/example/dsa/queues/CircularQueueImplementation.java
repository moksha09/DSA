package org.example.dsa.queues;

public class CircularQueueImplementation {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    protected int front = 0;
    protected int end = 0;
    private int size = 0;

    public CircularQueueImplementation(){
        this(DEFAULT_SIZE);
    }
    public CircularQueueImplementation(int size){
        this.data = new int[size];
    }

    public boolean isFull(){
        return size == data.length;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public boolean insert(int item){
        if(isFull()){
            System.out.println("Queue is FULL");
            return false;
        }

        data[end] = item;
        end++;
        end = end%data.length;
        size++;
        return true;
    }

    public int remove(){
        if(isEmpty()){
            System.out.println("Queue is EMPTY");
            return -1;
        }
        int removedItem = data[front];
        front++;
        front = front%data.length;
        size--;
        return removedItem;
    }

    public int front(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return data[front];
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        int i = front;
        do{
            System.out.println(data[i] + " ");
            i++;
            i = i% data.length;
        }while(i!=end);

        System.out.println("END");
    }
}
