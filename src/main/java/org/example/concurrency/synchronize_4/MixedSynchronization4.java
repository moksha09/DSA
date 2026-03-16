package org.example.concurrency.synchronize_4;

public class MixedSynchronization4 {

    public static Object staticObject = null;

    // The static method is synchronized on the MixedSynchronization class object as monitor obj
    public static synchronized void setObject(Object obj){
        staticObject = obj;
    }

    public Object instanceObject = null;

    // The instance method is synchronized on whatever instance of MS class the method is called on.
    public synchronized void setInstanceObject(Object obj){
        this.instanceObject = obj;
    }


}
