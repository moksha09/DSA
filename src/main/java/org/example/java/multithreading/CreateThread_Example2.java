package org.example.java.multithreading;

import org.example.dsa.concurrency.memory_3.SharedObjects;

class MyThread2 extends Thread{
    public void run(){
        System.out.println("Thread 1 is running ");
    }
}

public class CreateThread_Example2 {

    public static Object sharedObject = new Object();

    public static void main(String[] args){

        System.out.println("Main Thread Started");

        // more efficient way -
        Runnable objRunnable = () ->  {
            System.out.println("Thread 1 started");
            int local1 = 0;
            String threadName = Thread.currentThread().getName();
            System.out.println("Thread name = " + threadName);
            System.out.println(Thread.currentThread().getState());
            System.out.println(sharedObject.hashCode());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 1 completed");
        };

        Runnable objRunnable2 = () ->  {
            int local2 = 0; // local objects of thread
            System.out.println("Thread 2 started");
            String threadName = Thread.currentThread().getName();
            System.out.println("Thread name = " + threadName);
            System.out.println(Thread.currentThread().getState());
            System.out.println(sharedObject.hashCode() );

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 2 completed");
        };

        Thread objThread1 = new Thread(objRunnable, "Runnable Thread 1");
        objThread1.start();

        Thread objThread2 = new Thread(objRunnable2, "Runnable Thread 2");
        objThread2.start();

        System.out.println("Main thread ended");
    }

}
