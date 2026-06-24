package org.example.dsa.concurrency.memory_3;

public class RaceConditionSolutionShared {

    public static void main(String[] args){

        MyRunnableSync myRunnable = new MyRunnableSync();

        Thread thread1 = new Thread(myRunnable, "Thread 1");
        Thread thread2 = new Thread(myRunnable, "Thread 2");

        thread1.start();
        thread2.start();


    }
}
