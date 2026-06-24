package org.example.dsa.concurrency.memory_3;

public class MyRunnable implements Runnable {

    // count is a member field - belongs to the myRunnable object
    // so there will be a count field in each runnable object
    // since each thread gets its own runnable object -> each thread will have its own count field
    private int count = 0;

    // since this is a field it can be shared between threads
    private MyObject myObject = null;
    public MyRunnable(){};
    public MyRunnable(MyObject myObject){
        this.myObject = myObject;
    }

    @Override
    public void run() {

        // local var - hence each thread will have its own myObject instance stores in Heap
        // whether its shared thread or separate threads
        // MyObject myObject = new MyObject();
        // System.out.println(myObject);

        System.out.println(myObject);

        // local var = i
        // each thread will create its own copy of i (local var are never shared with threads
        for(int i=0; i<1_000_000; i++){
            this.count++;
        }
        System.out.println(Thread.currentThread().getName()+" : "+ this.count);
    }
}
