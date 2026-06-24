package org.example.dsa.concurrency.thread_1;

public class ThreadExample8 {

    // Daemon Thread - Mark a thread as a daemon thread -
    // JVM will stay alive even if there is any remaining thread still running.(even if the main thread has terminated)
    // 1) Normal non-daemon thread - will keep the JVM(Java Virtual Machine) running even if the
    // main thread exits the application
    // 2) Daemon thread - does not keep the JVM running when the main thread exits application

    // Example -
    public static void main(String[] args){
        Runnable runnable = () -> {
            while(true){
                sleep(1000);
                System.out.println("Running");
            }
        };

//        Thread thread = new Thread(runnable);
//        thread.start();
        // If you dont want the thread to keep JVM alive, you have to mark it as a daemon thread
        Thread thread2 = new Thread(runnable);
        thread2.setDaemon(true);
        thread2.start();
        sleep(3100); // main thread sleeps for 3s and then terminates since it has no use
        // on running you will say even after the main thread has terminated after 3 sec the other thread keeps running
        // keeping the JVM alive
    }

    // These daemons thread are stopped in an undefined state -so make sure that these threads are not
    // in the middle of any other important operation, cause terminating it would cause undesired side effect

    public static void sleep(long millis){
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
