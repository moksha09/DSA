package org.example.dsa.concurrency.race_condition_7;

public class RaceConditionExample3 {

    public static void main(String[] args){

        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        Thread thread1 = new Thread(getRunnable(counter1, counter2, "Thread 1"));
        Thread thread2 = new Thread(getRunnable(counter2, counter1, "Thread 2"));

        // We do not have race conditions here because - the writing is being done by different threads
        // with different runnables. - for thread1 -> counter1 is writing and for thread2 -> counter2 is writing
        // hence we would get correct output even when we are using synch. counter

        thread1.start();
        thread2.start();


    }

    private static Runnable getRunnable(Counter counterA, Counter counterB, String runnableName){
        return () -> {
            for(int i=0; i<1000_000; i++){
                counterA.incAndGet();
            }
            System.out.println(runnableName + " final count counterA = " + counterA.get());
            System.out.println(runnableName + "  final count counterB = " + counterB.get());
        };
    }
}
