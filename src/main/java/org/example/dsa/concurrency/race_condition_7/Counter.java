package org.example.dsa.concurrency.race_condition_7;

public class Counter {
    private int count = 0;

    public int incAndGet(){
        this.count++;
        return this.count;
    }

    public int get(){
        return this.count;
    }
}
