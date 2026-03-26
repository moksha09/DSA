package org.example.concurrency.java_lock_10;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample2 {

    public static void main(String[] args){
        lockBasics();
    }

    private static void lockBasics(){
        // create a new lock
        Lock lock = new ReentrantLock(false);

        // create a runnable
        Runnable runnable = () -> {
            lockSleepUnlock(lock, 1000);
        };

        Thread thread1 = new Thread(runnable, "Thread 1");
        Thread thread2 = new Thread(runnable, "Thread 2");
        Thread thread3 = new Thread(runnable, "thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void lockSleepUnlock(Lock lock, long timeMillis) {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " holds the lock. ");
            Thread.sleep(timeMillis);
        }catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
