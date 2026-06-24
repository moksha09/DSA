package org.example.dsa.concurrency.java_lock_10;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample1 {

    public static void main(String[] args){

        Lock lock = new ReentrantLock();

        lock.lock();
        //do something
        lock.unlock();
    }
}
