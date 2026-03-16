package org.example.concurrency.thread_1;

public class ThreadExample7 {
    // How to stop a thread -
    // Java's thread class do have a stop() method to stop a thread but its deprecated and we should never use it.
    // Using stop() -> does stop the thread but you have no idea in what state the thread was stopped in.
    // That means, that all Java objects the thread had access to during execution would be left in an unknown state.
    // If other threads in your application also has access to the same objects, your application could fail unexpectedly and unpredictably.

    // The BEST practise is stopping it yourself -

    public static class StoppableRunnable implements Runnable {

        private boolean stopRequested = false;

        public synchronized void  requestStop() {
            this.stopRequested = true;
        }

        public synchronized boolean isStopRequested(){
            return this.stopRequested;
        }

        private void sleep(long millis){
            try{
                Thread.sleep(millis);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }


        @Override
        public void run() {
            System.out.println("StoppableRunnable running");
            while(!isStopRequested()){
                sleep(1000);
                System.out.println(".......");
            }
            System.out.println("Stoppable runnable stopped");
        }
    }

    public static void main(String[] args){
        StoppableRunnable stoppableRunnable = new StoppableRunnable();
        Thread thread = new Thread(stoppableRunnable, "Thread 1");
        thread.start();

        try {
            Thread.sleep(5000);  // Here the main thread stops for 5s not Thread 1
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Requesting to stop the thread");
        stoppableRunnable.requestStop(); // we are calling the requestStop method on the runnable not on the thread
        System.out.println("Stop requested");
    }

}
