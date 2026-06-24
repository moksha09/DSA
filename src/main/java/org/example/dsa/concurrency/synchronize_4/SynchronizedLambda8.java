package org.example.dsa.concurrency.synchronize_4;

import java.util.function.Consumer;

public class SynchronizedLambda8 {

    private static Object object = null;

    public static synchronized void setObject(Object obj){
        object = obj;
    }

    public static void consumeObject(Consumer consumer){
        consumer.accept(object);
    }

    public static void main(String[] args){
        // using lambda expression to make consumeObject synchronous
        consumeObject((obj)-> {
            synchronized (SynchronizedLambda8.class){
                System.out.println(obj);
            }
        });

        consumeObject((obj) -> {
            synchronized (String.class){// wont work
                System.out.println(obj);
            }
        });
    }
}
