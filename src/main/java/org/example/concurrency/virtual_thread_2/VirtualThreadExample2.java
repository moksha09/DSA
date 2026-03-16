package org.example.concurrency.virtual_thread_2;

import java.util.ArrayList;
import java.util.List;

public class VirtualThreadExample2 {

    // Creating multiple virtual thread -

    public static void main(String[] args){

        List<Thread> vThreads = new ArrayList<>();
        // running 100000 virtual threads
        int vThreadCount = 100_000;

        for(int i=0; i<vThreadCount; i++){
            int vThreadIndex = i;
            Thread vThread = Thread.ofVirtual().start(() -> {
                int result = 1;
                for(int j=0; j<10; j++){
                    result = result*(j+1);
                }
                System.out.println("Result[ "+vThreadIndex+" ]: "+ result);
            });
            vThreads.add(vThread);
        }

        for(int i=0; i<vThreads.size(); i++){
            try{
                vThreads.get(i).join(); // telling the main thread to wait for all the virtual thread to finish
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
