package org.example.dsa.concurrency.virtual_thread_2;

public class VirtualThreadExample {

    public static void main(String[] args){

        // Example 1: Create a runnable. Create and start virtual thread -
        Runnable runnable = () -> {
            for(int i=0; i<10; i++){
                System.out.println("Index: "+i);
            }
        };

        Thread vThread1 = Thread.ofVirtual().start(runnable);

        // Example 2 - Create virtual thread but do not start -

        Thread vThread2 = Thread.ofVirtual().unstarted(runnable);
        // start separately -
        vThread2.start();

        // Example 3 - Joining a virtual thread -
        try{
            vThread2.join(); // will block the platform thread, until this virtual thread has finished executing
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
