package org.example.concurrency.thread_pool_9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Manual implementation of threadPool -
public class ThreadPool {

    private BlockingQueue<Runnable> taskQueue = null; // consists of all the tasks which needs to be run

    // list of pool thread runnables also implementation of runnables -
    // they are not tasks, they implement/provide the functionality that is needed by the poolThread
    // in order to take tasks out of the queue - execute them - then go back and take the next task
    // until they are signalled to stop or shut down.
    private List<PoolThreadRunnable> runnables = new ArrayList<>();

    // to tell whether the threadPool is shut down or not
    private boolean isStopped = false;

    // noOfThreads to create internally in threadPool &
    // max number of tasks that the ArrayBlockingQueue that we use to store the tasks can hold maximally
    public ThreadPool(int noOfThreads, int maxNoOfTasks){
        taskQueue = new ArrayBlockingQueue<>(maxNoOfTasks);
        for(int i=0; i<noOfThreads; i++){
            // for each pool thread runnable - it gets access to the taskQueue so that it can take the task from queue and run it
            PoolThreadRunnable poolThreadRunnable = new PoolThreadRunnable(taskQueue);
            // then each of this runnable is added to the runnable list -
            runnables.add(poolThreadRunnable);
        }

        // creates a thread for each polThreadRunnable and starts the thread.
        for(PoolThreadRunnable runnable : runnables){
            new Thread(runnable).start();
        }
    }

    // This is how we submit a task to the ThreadPool -
    // argument = Implementation of Runnable
    public synchronized void execute(Runnable task) throws Exception{
        // first check if the ThreadPool is stopped or not if it is - you cannot submit any more tasks to the threadPool
        if(this.isStopped) throw new IllegalArgumentException("ThreadPool is stopped");
        // ELSE - you can just enqueue the task to the taskQueue =
        this.taskQueue.offer(task);
    }

    // Method to stop the threadPool -

    public synchronized void stop(){
        this.isStopped = true;
        for(PoolThreadRunnable runnable : runnables){
            runnable.doStop();
        }
    }

    public synchronized void waitUntilAllTasksFinished(){
        while(this.taskQueue.size()>0){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
