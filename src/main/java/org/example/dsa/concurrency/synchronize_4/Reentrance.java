package org.example.dsa.concurrency.synchronize_4;

public class Reentrance {
    private int count = 0;

    public synchronized void inc(){
        this.count++;
    }

    public synchronized int incAndGet(){
        inc();
        return this.count;
    }

    public synchronized int get(){
        return this.count;
    }

    public static void main(String[] args){
        Reentrance reentrance = new Reentrance();
        System.out.println(reentrance.incAndGet());
    }
}
