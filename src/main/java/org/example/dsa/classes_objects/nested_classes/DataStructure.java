package org.example.dsa.classes_objects.nested_classes;

import java.util.Iterator;
import java.util.function.Function;

public class DataStructure {

    private static final int SIZE = 15;
    private int[] arrOfInt = new int[SIZE];

    public DataStructure() {
        for(int i=0; i<SIZE; i++){
            arrOfInt[i] = i;
        }
    }

    // method to print only the even indices of array -
    public void printEven(){
        DataStructureIterator iterator = this.new EvenIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public void print(DataStructureIterator iterator){
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public void print(Function<Integer, Boolean> iterator){
        for(int i=0; i<SIZE; i++){
            if(iterator.apply(arrOfInt[i])){
                System.out.println(arrOfInt[i]);
            }
        }
    }

    public static Boolean isEvenIndex(Integer integer){
        return (integer%2==0);

    }

    public static Boolean isOddIndex(Integer integer){
        return (integer%2!=0);
    }

    interface DataStructureIterator extends Iterator<Integer> {}

    // inner class with the method -
    private class EvenIterator implements DataStructureIterator {

        private int nextIndex = 0; // starting from start

        @Override
        public boolean hasNext() {
            return (nextIndex<=SIZE-1);
        }

        @Override
        public Integer next() {
            Integer value = Integer.valueOf(arrOfInt[nextIndex]);
            nextIndex = nextIndex+2;
            return value;
        }
    }

    // inner class for printing odd number -
    private class OddIterator implements DataStructureIterator {

        int nextIndex = 1;

        @Override
        public boolean hasNext() {
            return (nextIndex<=SIZE-1);
        }

        @Override
        public Integer next() {
            Integer value = Integer.valueOf(arrOfInt[nextIndex]);
            nextIndex = nextIndex+2;
            return value;
        }
    }

    public static void main(String[] args){
        DataStructure ds = new DataStructure();
        //ds.printEven();
        //ds.print(ds.new EvenIterator());
//        ds.print(new DataStructureIterator() {
//            int nextIndex = 1;
//            @Override
//            public boolean hasNext() {
//                return (nextIndex<=SIZE-1);
//            }
//
//            @Override
//            public Integer next() {
//                Integer value = Integer.valueOf(ds.arrOfInt[nextIndex]);
//                nextIndex = nextIndex+2;
//                return value;
//            }
//        });
//        ds.print((Integer integer) -> (integer%2==0));
        ds.print(DataStructure::isEvenIndex);
        ds.print(DataStructure::isOddIndex);
    }



}
