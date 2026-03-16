package org.example.concurrency.memory_3;

public class SharedObjects {

    // sharing the same runnable instance -
    public static void main(String[] args){

        MyObject myObject = new MyObject();
        Runnable runnable = new MyRunnable(myObject);

        Thread thread1 = new Thread(runnable, "Thread 1");
        Thread thread2 = new Thread(runnable, "Thread 2");

        thread1.start();
        thread2.start();
    }
}
