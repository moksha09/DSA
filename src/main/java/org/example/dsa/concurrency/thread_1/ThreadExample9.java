package org.example.dsa.concurrency.thread_1;

public class ThreadExample9 {

    // Its is possible for a thread to wait for another thread to complete/terminate by-
    // JOINING threads

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                sleep(1000);
                System.out.println("Running....");
            }
        };

        Thread thread = new Thread(runnable, "Thread 1");
        thread.setDaemon(true);
        thread.start();

        // we need to the main thread to wait for Thread 1 to complete ,
        // or else the main thread would terminate instantly causing Thread 1 to terminate too without
        // running its code. We can do this join -

        try {
            // this tells the main thread to wait for this thread -
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(long millis){
        try{
            Thread.sleep(millis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
