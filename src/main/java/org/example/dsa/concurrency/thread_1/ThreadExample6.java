package org.example.dsa.concurrency.thread_1;

public class ThreadExample6 {

    //Putting a thread to sleep by calling Thread.sleep method -
    public static void main(String[] args){

        // create a runnable using lambda expression -
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+ " running..");

            try {
                Thread.sleep(3000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println(threadName + " finished running");
        };

        Thread thread1 = new Thread(runnable, "Thread 1");
        thread1.start();
    }
}
