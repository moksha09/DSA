package org.example.java.multithreading;

class MyThread extends Thread{
    public void run(){
        System.out.println("Thread 1 is running ");
    }
}

public class CreateThread_Example1 {

    public static void main(String[] args){

        System.out.println("Main Thread Started");

        Thread objThread = new MyThread();
        objThread.start(); // new thread will be started

        Thread objThread2 = new Thread(() -> {  // use lambda expression to give implementation of run method
            System.out.println("Thread 2 is running");
        });
        objThread2.start();

        // more efficient way -
        Runnable objRunnable = () ->  {
            System.out.println("Thread 3 started");
            String threadName = Thread.currentThread().getName();
            System.out.println("Thread name = " + threadName);
            System.out.println(Thread.currentThread().getState());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 3 completed");
        };

        Thread objThread3 = new Thread(objRunnable, "Runnable Thread 3");
        // making objThread 3 as daemon thread so tht it doesnt effect the main thread and can keep running
        // in background.
        objThread3.setDaemon(true);
        objThread3.start();

        System.out.println("Main thread ended");
    }

}
