package org.example.dsa.concurrency.java_volatile_5;

public class Counter {

    private volatile int count = 0;

    public boolean inc(){
         if(this.count == 10){
             return false;
         }
         this.count++;
         // the increment statement in java is not atomic -
        // it consists of -
        // 1) reading count variable from main memory
        // 2) incrementing the variable happening in local register in cpu
        // 3) writing the variable to the memory
         return true;

         // Using a volatile variable doesn't guarantee concurrent behavior -
        // Lets say we have 2 threads - t1 and t2 - both of them are running the inc()
        // in its own count variable. let's say initially count = 0; t1 sees that and increases the count
        // value to 1, similarly t2 having its own count - 0, increases its value to 1 and writes to main memory at same time
        // so now rather than having count value as 2 by running t1 and t2, we will have count value as 1. If t2 is
        // a bit slower than t1 then maybe count value can be correct =2 , but its not a guarantee.

        // Hence, it's always advised to rather use -
        // 1) synchronized blocks
        // 2) AtomicInteger/Long from java concurrent api's
    }
}
