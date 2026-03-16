package org.example.concurrency.thread_1;

public class ThreadExample5 {
    // Starting more than one thread -
    public static void main(String[] args){
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " running...");
        };

        // You don't know which order these threads are going to be executed
        // .i.e we dont know in which order the CPU or the OS system is switching between these
        // two runnable executing the thread.
        Thread thread1 = new Thread(runnable, "Thread 1");
        thread1.start();
        Thread thread2 = new Thread(runnable, "Thread 2");
        thread2.start();
    }
}
