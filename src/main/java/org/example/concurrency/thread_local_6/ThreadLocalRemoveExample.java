package org.example.concurrency.thread_local_6;

public class ThreadLocalRemoveExample {

    public static void main(String[] args){

        // Creating a single thread local of type string -
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        // The values for thread1 and thread2 will be kept separately
        // inside the thread Local

        Thread thread1 = new Thread(()->{
            threadLocal.set("Thread 1");

            try{
                Thread.sleep(2000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            String value = threadLocal.get();
            System.out.println(value);
            threadLocal.remove();
            System.out.println(threadLocal.get());

        });

        Thread thread2 = new Thread(()->{
            threadLocal.set("Thread 2");

            try{
                Thread.sleep(2000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            String value = threadLocal.get();
            System.out.println(value);
            threadLocal.remove();
            System.out.println(threadLocal.get());
        });

        thread1.start();
        thread2.start();
    }
}
