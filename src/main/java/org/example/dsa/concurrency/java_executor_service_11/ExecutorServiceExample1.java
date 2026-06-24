package org.example.dsa.concurrency.java_executor_service_11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample1 {

    public static void main(String[] args){

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(newRunnable("Task 1"));
        executorService.execute(newRunnable("Task 2"));
        executorService.execute(newRunnable("Task 3"));

        executorService.shutdown();
    }

    private static Runnable newRunnable(String msg) {
        return () -> {
            System.out.println(msg);
        };
    }
}
