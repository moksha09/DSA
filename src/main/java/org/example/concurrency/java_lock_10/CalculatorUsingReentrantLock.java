package org.example.concurrency.java_lock_10;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CalculatorUsingReentrantLock {

    public static class Calculation {
        public static final int UNSPECIFIED = -1;
        public static final int ADDITION = 0;
        public static final int SUBTRACTION = 1;

        int type = UNSPECIFIED;

        public double value;

        public Calculation(int type, double value){
            this.type = type;
            this.value = value;
        }

        private double result = 0.0D;

        Lock lock = new ReentrantLock(true);

        public void add(double value){
            try {
                lock.lock();
                this.result += value;
            } finally {
                lock.unlock();
            }
        }

        public void subtract(double value){
            try {
                lock.lock();
                this.result -= value;
            } finally {
                lock.unlock();
            }
        }

        public void calculate(Calculation ... calculations){
            try {
                lock.lock();
                for(Calculation calculation : calculations){
                    switch (calculation.type){
                        case Calculation.ADDITION -> { // the lock will be locked 2 times as the
                            add(calculation.value);    // add method also has a lock method inside it
                            break;          // hence lock reentrance is necessary
                        }
                        case Calculation.SUBTRACTION -> {
                            subtract(calculation.value);
                            break;
                        }
                    }
                }
            } finally {
                lock.unlock();
            }
        }



    }
}
