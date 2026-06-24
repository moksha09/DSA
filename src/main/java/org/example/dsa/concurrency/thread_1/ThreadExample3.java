package org.example.dsa.concurrency.thread_1;

public class ThreadExample3 {
    // 2) Another way to specify what code the thread should run is -
    // Creating a class that implements java.lang.Runnable interface.
    // A java object that implements a runnable interface can be executed by a Java thread
    // The Runnable interface has a single method called run()

    // Whatever the thread needs to execute must be included in the implementation of the run() method.
    // There are 3 ways to implement Runnable interface -

    // 2.1) Create a Java class that implements Runnable interface -

    public static class MyRunnable1 implements Runnable {

        @Override
        public void run() {
            System.out.println("My Runnable is running");
        }
    }

    // 2.2) Anonymous implementation of Runnable -
    Runnable myRunnable2 = new Runnable() {
        @Override
        public void run() {
            System.out.println("Runnable running");
        }
    };

    // 2.3) JAVA lambda impl of runnable -
    Runnable myRunnable3 = () -> {
        System.out.println("My runnable running");
    };

    public static void main(String[] args){
        Thread thread = new Thread(()->{
            System.out.println("My runnable is running");
        });
        thread.start();
    }

}
