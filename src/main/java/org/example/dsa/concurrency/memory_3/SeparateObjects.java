package org.example.dsa.concurrency.memory_3;

public class SeparateObjects {

    public static void main(String[] args){

        // Example 1-
        // these are local variables - variables defined inside a method -they belong to this method -
        int myLocalVar = 0; // this local var will be stored in thread stack
        String myLocalString = "Text"; // this is an object , so the object reference - myLocalString, will be stored in thread stack, but the actual object i.e "Text" will be stored in heap


        // Example 2-
        // Creating 2 separate runnable objects for each thread. So in Heap memory we will have runnable1 and runnable 2 present

        MyObject myObject = new MyObject();

        //passing the same myObject to both runnables
        Runnable runnable1 = new MyRunnable(myObject);
        Runnable runnable2 = new MyRunnable(myObject);

        Thread thread1 = new Thread(runnable1, "Thread 1");
        Thread thread2 = new Thread(runnable2, "Thread 2");

        thread1.start();
        thread2.start();

    }

}
