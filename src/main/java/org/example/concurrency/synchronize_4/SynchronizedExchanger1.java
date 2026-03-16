package org.example.concurrency.synchronize_4;

public class SynchronizedExchanger1 {

    protected Object object = null;

    // The synchronized keyword can be used to mark four different types of blocks: -

    // 1) Making instance method synchronized - can be executed by only one thread at a time
    public synchronized void setObject(Object object){
        this.object = object;
    }

    public synchronized Object getObject(){
        return this.object;
    }

    // 2) Synchronized Code blocks inside instance method - can be executed by only one thread at a time
    // we pass "this" -> also called as monitor object as param to synchronized . A monitor object is
    // the obj on which these methods or blocks are synchronized.
    public void setObj(Object o){
        synchronized(this){
            this.object = o;
        }
    }

    public Object getObj(){
        synchronized(this){
            return this.object;
        }
    }

    // ** Since all the 4 methods are all synchronized on the same monitor obj =  the instance of
    // SynchronizedExchanger class ->That means only one thread can enter one of these sync blocks at the same time for a particular instance.
    // If we have 2 threads having its own separate SE instance (i.e we have 2 instance), then we each of those thread can parallely
    // enter/run any one of the sync methods.
}
