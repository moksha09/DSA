package org.example.system_design.exercise.singleton.counter;

public class BillPughSingleton {
    /**
     * Implement Singleton Counter Class - easy
     *
     * Problem: Implement a Counter singleton that tracks a count across the application.
     * Multiple components should be able to increment the counter, and all must see the same value.
     *
     * Requirements:
     *      - increment() increases the count by 1
     *      - getCount() returns the current count
     *      - Thread-safe: concurrent increments must not lose updates
     *      - Calling the constructor/access method from different places returns the same instance
     */

    private int count = 0;

    private BillPughSingleton(){
    }

    private static class Holder{
        private static final BillPughSingleton instance = new BillPughSingleton();

    }

    public void increment(){
        Holder.instance.count++;
    }

    public int getCount(){
        return Holder.instance.count;
    }

    public static BillPughSingleton getInstance(){
        return Holder.instance;
    }

    public static void main(String[] args) {
        // After implementing, usage should look like:
        BillPughSingleton c1 = BillPughSingleton.getInstance();
        BillPughSingleton c2 = BillPughSingleton.getInstance();
        System.out.println("Same instance: " + (c1 == c2));
         for (int i = 0; i < 5; i++) {
             c1.increment();
         }
         System.out.println("Count after 5 increments: " + c1.getCount());
    }
}
