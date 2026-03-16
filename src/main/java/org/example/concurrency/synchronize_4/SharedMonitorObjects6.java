package org.example.concurrency.synchronize_4;

public class SharedMonitorObjects6 {

    private Object monitor = new Object();
    private int count = 0;

    public SharedMonitorObjects6(Object obj){
        if(obj==null){
            throw new IllegalArgumentException("Monitor object cannot be null");
        }
        this.monitor = obj;
    }

    public void incCounter(){
        synchronized (this.monitor){
            this.count++;
        }
    }

}
