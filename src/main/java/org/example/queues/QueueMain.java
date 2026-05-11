package org.example.queues;

public class QueueMain {

    public static void main(String[] args){
        DynamicQueueImplementation queue = new DynamicQueueImplementation(5);

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        queue.insert(8);

        queue.remove();
        queue.remove();
        queue.insert(100);

        queue.display();

    }
}
