package org.example.concurrency.memory_3;

public class RaceConditionSharedObjects {

    public static void main(String[] args){

        MyRunnable myRunnable = new MyRunnable();

        // here the count is being shared by both threads
        Thread thread1 = new Thread(myRunnable, "Thread 1");
        Thread thread2 = new Thread(myRunnable, "Thread 2");

        // if counting was synch. then the output for th1 = 1million, th2 = 2million
        // however when you run you will get a different result (check)
        // this is because the threads are reading and writing the count at the same time causing incorrect count
        // they cant see that one thread is in the middle of updating the count and hence wont wait
        thread1.start();
        thread2.start();


    }
}
