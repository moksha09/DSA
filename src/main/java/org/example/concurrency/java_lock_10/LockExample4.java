package org.example.concurrency.java_lock_10;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample4 {

    public static void main(String[] args){
        lockBasics();
    }

    private static void lockBasics(){
        // create a runnable
        Runnable runnable = LockExample4::tryLock;
        Thread thread1 = new Thread(runnable, "Thread 1");
        Thread thread2 = new Thread(runnable, "Thread 2");
        Thread thread3 = new Thread(runnable, "thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void tryLock(){
    Lock lock = new ReentrantLock();
    try {
        //
        boolean lockSuccessful = lock.tryLock();
        // will simply attempt to check the lock - and if
        // or lock the lock and if that does not succeed because
        // another thread is holding the lock -
        // rather than blocking it until it is possible to lock the lock
        // the tryLock() method will return false.
        // and if it is successful in locking the lock - it will return true
        System.out.println("Lock successful: " + lockSuccessful);
    } finally {
        lock.unlock();
      }
    }

}
