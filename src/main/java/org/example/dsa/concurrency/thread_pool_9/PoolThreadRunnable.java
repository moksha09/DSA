package org.example.dsa.concurrency.thread_pool_9;

import java.util.concurrent.BlockingQueue;

// Its a standard java class which implements the runnable class so that we can pass it to a thread and execute it
public class PoolThreadRunnable implements Runnable{

    private BlockingQueue<Runnable> taskQueue = null; // the queue from where the tasks are taken for execution
    private Thread thread = null; // which references the thread which executes this
    private Boolean isStopped = false; // whether the poolthreadrunnable is asked to stop or not

    public PoolThreadRunnable(BlockingQueue<Runnable> queue){
        this.taskQueue = queue;
    }


    @Override
    public void run() {
        // stores a reference to the thread which is executing this runnable -
        this.thread = Thread.currentThread();
        // as long as the poolThreadRunnable is not asked to stop it will take a task form the taskqueue and run it-
        while(!isStopped()){
            try{
                // it will take one runnable out of the taskQueue and call run on it -
                // ** The take() method here is BLOCKING method - if there are no tasks in the task queue then this
                // thread("the thread which is executing the runnable") is blocked indefinitely
                Runnable runnable = taskQueue.take();
                runnable.run();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public synchronized boolean isStopped(){
        return this.isStopped;
    }

    public synchronized void doStop(){
        isStopped = true;
        // break pool thread out of deque call
        this.thread.interrupt();
    }


}
