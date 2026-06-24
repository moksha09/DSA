package org.example.dsa.concurrency.java_lock_10;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample3 {

    public static void main(String[] args){
        lockBasics();
    }

    private static void lockBasics(){
        // create a runnable
        Runnable runnable = LockExample3::lockInterruptibly;

        Thread thread1 = new Thread(runnable, "Thread 1");
        Thread thread2 = new Thread(runnable, "Thread 2");
        Thread thread3 = new Thread(runnable, "thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void lockInterruptibly(){
        Lock lock = new ReentrantLock();
        Thread.currentThread().interrupt();
        try {
            // will only lock the lock if the thread that is trying to lock the lock has
            // not been interrupted
            lock.lockInterruptibly();
            lock.unlock();
        } catch (InterruptedException e){
            System.out.println("Thread interrupted.");
        }
    }
}
