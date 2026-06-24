package org.example.dsa.concurrency.synchronize_4;

public class StaticSynchronizedExchanger3 {


    private static Object object = null;

    // 3) synchronized keyword in static methods
    public static synchronized void setObject(Object obj){
        object = obj;
    }

    public static synchronized Object getObject(){
        return object;
    }

    // 4) synchronized code block inside static methods - uses classObject for object monitor since they belong to a class but not to an instance
    public static void setObj(Object obj){
        synchronized (StaticSynchronizedExchanger3.class){
            object = obj;
        }
    }

    public static Object getObj(){
        synchronized (StaticSynchronizedExchanger3.class){
            return object;
        }
    }
}
