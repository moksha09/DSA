package org.example.java.multithreading.atomic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class SharedCounter {
//    private int counter = 0;
//    private AtomicInteger counter = new AtomicInteger(0);
    private int counter = 0;

    public synchronized void increment(){
//        counter.incrementAndGet();
        counter++;
    }

    public synchronized int getCounter(){
//        return counter.get();
        return counter;
    }
}

public class Atomic {
    public static void main(String[] args){
        SharedCounter sharedCounter = new SharedCounter();

        // Thread 1 -
        new Thread(() -> {
            System.out.println("Thread 1 started");
            for(int i=0; i<50000; i++){
                sharedCounter.increment();
            }
            System.out.println("Thread 1 completed");
        }).start();

        // Thread 2 -
        new Thread(() -> {
            System.out.println("Thread 2 started");
            for(int i=0; i<50000; i++){
                sharedCounter.increment();
            }
            System.out.println("Thread 2 completed");
            System.out.println("Final count = " + sharedCounter.getCounter());
        }).start();



    }
}
