package org.example.concurrency.race_condition_7;

public class RaceConditionExample2 {
    // Only one thread is writing and another thread is reading -
    /// Here we do have a visibility problem but not race condition (since the second threads is just trying to res not write at he same time)

    public static void main(String[] args){
        Counter counter = new Counter();

        Thread thread1 = new Thread(getIncrementingRunnable(counter));
        Thread thread2 = new Thread(getReadingRunnable(counter));

        thread1.start();
        thread2.start();

    }

    private static Runnable getIncrementingRunnable(Counter counter){
        return () -> {
            for (int i=0; i<1000_000; i++){
                counter.incAndGet();
            }
            System.out.println("Thread 1 count = "+ counter.get());
        };
    }

    private static Runnable getReadingRunnable(Counter counter){
        return () -> {
            for(int i=0; i<5; i++){
                try{
                    Thread.sleep(1);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Thread 2 count = " + counter.get());
            }
        };
    }
}
