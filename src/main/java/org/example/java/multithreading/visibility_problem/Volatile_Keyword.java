package org.example.java.multithreading.visibility_problem;

class SharedResource {

//    private volatile boolean flag = false;
    private boolean flag = false;

    public synchronized void setFlag(boolean flag) {
        this.flag = flag;
    }

    public synchronized boolean getFlag() {
        return flag;
    }
}

public class Volatile_Keyword {

    public static void main(String[] args) throws Exception {

        SharedResource sharedResource = new SharedResource();

        // Thread 1 -
        new Thread(() -> {
            try {
                System.out.println("Thread 1 started");
                Thread.sleep(2000);
                System.out.println("Thread 1 logic completed");
                sharedResource.setFlag(true);
                System.out.println("Flag set true by thread 1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        // Thread 2 -
        new Thread(() -> {
            System.out.println("Thread 2 has started");
            while(!sharedResource.getFlag()){
                // it will run until the flag become true
            }
            System.out.println("Thread 2 logic completed");
        }).start();

        // The thread 2 keeps running even though the flag is set to true by thread1.
    }

}
