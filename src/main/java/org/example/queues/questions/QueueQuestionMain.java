package org.example.queues.questions;

public class QueueQuestionMain {

    public static void main(String[] args){
        ImplementQueueUsingStack_LC232 queue = new ImplementQueueUsingStack_LC232();

        queue.push(1);
        queue.push(2);
        queue.push(3);

        int item = queue.peek();
        int x = queue.pop();
        int y = queue.pop();
        int z = queue.peek();

        boolean isEmplty = queue.empty();

        System.out.println("first item - "+ item);
        System.out.println("removing 1 item from queue - " + x);
        System.out.println("removing 1 item from queue - " + y);
        System.out.println("first item from queue - " + z);
        System.out.println("is queue empty - "+ isEmplty);
    }
}
