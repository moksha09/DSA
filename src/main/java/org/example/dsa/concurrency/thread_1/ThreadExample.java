package org.example.dsa.concurrency.thread_1;

public class ThreadExample {
    // The "main" method is actually executed by a thread when the JVM starts execution
    public static void main(String[] args){

        Thread thread = new Thread();
        thread.start(); // this will start the thread to run in parallel to the "main" method thread at the same time
        // since this thread is currently not doing anything, it will start and stop immediately
    }
}
