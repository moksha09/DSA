package org.example.dsa.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class JavaPriorityQueue {

    public static void main(String[] args){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(10);
        minHeap.add(5);
        System.out.println(minHeap.peek());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(5);
        System.out.println(maxHeap.peek());
    }

}
