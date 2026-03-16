package org.example.concurrency.synchronize_4;

public class SharedMonitorObjectMain7 {

    public static void main(String[] args){
        Object monitor1 = new Object();


        SharedMonitorObjects6 smol1 = new SharedMonitorObjects6(monitor1);
        SharedMonitorObjects6 smol2 = new SharedMonitorObjects6(monitor1);

        Object monitor2 = new Object();

        SharedMonitorObjects6 smol3 = new SharedMonitorObjects6(monitor2);

        // here the sync blocks inside both smol1 and smol2 have the same monitor object,
        // hence calls from diff threads to either smol1.incCounter() or smol2.incCounter()
        // will block each other.
        smol1.incCounter();
        smol2.incCounter();

        // since we have a diff monitor obj. -> for smol3 if a thread call incCounter() method
        // other threads calling the same method for smol1 and smol2 wont be blocked
        smol3.incCounter();


    }
}
