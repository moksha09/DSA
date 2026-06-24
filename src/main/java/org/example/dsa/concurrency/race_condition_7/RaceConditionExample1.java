package org.example.dsa.concurrency.race_condition_7;

public class RaceConditionExample1 {
    // Read Modify Write problem -

    public static void main(String[] args){
        Counter counter = new Counter();

        Thread thread1 = new Thread(getRunnable(counter, "Thread 1 final count = "));
        Thread thread2 = new Thread(getRunnable(counter, "Thread 2 final count = "));

        thread1.start();
        thread2.start();

        SynchronizedCounter counter1 = new SynchronizedCounter();

        Thread thread3 = new Thread(getRunnable(counter1, "Thread 3 final count = "));
        Thread thread4 = new Thread(getRunnable(counter1, "Thread 4 final count = "));

        thread3.start();
        thread4.start();

    }

    private static Runnable getRunnable(Counter counter, String message){
        Runnable runnable = () -> {
            for(int i=0; i<1_000_000; i++){
                counter.incAndGet();
            }
            System.out.println(message + counter.get());
        };
        return runnable;
    }

    private static Runnable getRunnable(SynchronizedCounter counter, String message){
        Runnable runnable = () -> {
            for(int i=0; i<1_000_000; i++){
                counter.incAndGet();
            }
            System.out.println(message + counter.get());
        };
        return runnable;
    }
}
