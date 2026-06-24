package org.example.dsa.concurrency.synchronize_4;

public class SynchronizedExchangerMain2 {

    public static void main(String[] args){

        SynchronizedExchanger1 synchronizedExchanger1 = new SynchronizedExchanger1();

        Thread thread1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0; i<1000; i++){
                            synchronizedExchanger1.setObject(""+i);
                        }
                    }
                }
        );

        Thread thread2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0; i<1000; i++){
                            System.out.println(synchronizedExchanger1.getObject());
                        }
                    }
                }
        );

        thread1.start();
        thread2.start();

    }
}
