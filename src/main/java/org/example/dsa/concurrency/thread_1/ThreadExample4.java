package org.example.dsa.concurrency.thread_1;

public class ThreadExample4 {

    // Obtaining reference to current executing thread -
    // The Runnable can get the current thread its executing -
    public static void main(String[] args){
        Runnable runnable = () -> {
            String currentThreadName = Thread.currentThread().getName();
            System.out.println("Thread name - "+ currentThreadName);
            System.out.println("Lambda running ");
            System.out.println("Lambda finished");
        };

        // specifying the name of a thread when creating it - (try running the program
        Thread thread1 = new Thread(runnable, "Thread 1");
        thread1.start();
    }
}
