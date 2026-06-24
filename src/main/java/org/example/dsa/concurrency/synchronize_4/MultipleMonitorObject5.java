package org.example.dsa.concurrency.synchronize_4;

public class MultipleMonitorObject5 {

    private Object myMonitor1 = new Object();
    private Object myMonitor2 = new Object();

    private int counter1 = 0;
    private int counter2 = 0;

    public void incCounter1(){
        synchronized (this.myMonitor1){
            this.counter1++;
        }
    }

    public void incCounter2(){
        synchronized (this.myMonitor2){
            this.counter2++;
        }
    }
}
