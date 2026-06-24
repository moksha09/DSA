package org.example.dsa.concurrency.thread_1;

public class ThreadExample2 {

    // There are 2 ways you can specify which code the thread will run -
    // 1) Create a subclass of Thread and override the run() method as below

    public static class MyThread extends Thread {
        // The run() method is what is executed by the thread after you call start()
        @Override
        public void run() {
            System.out.println("My thread is running");
            System.out.println("My thread is finished");
        }
    }

    public static void main(String[] args){
        MyThread myThread = new MyThread();
        // The start() call will return as soon as the thread is started. It won't wait until the
        // run() method is done.
        // The run() method will execute as if its being executed by a diff CPU
        myThread.start();

        // another way -
        Thread thread2 = new Thread(){
            public void run(){
                System.out.println("Thread 2 is running");
                System.out.println("Thread 2 has stopped");
            }
        };
        thread2.start();
    }
}
