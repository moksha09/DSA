package org.example.dsa.heaps.practise;

import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> {

    ArrayList<T> list ;
    public MinHeap(){
        this.list = new ArrayList<>();
    }
     private int parent(int index){
        return (index-1)/2;
     }

     private int left(int index){
        return (index*2)+1;
     }

     private int right(int index){
        return (index*2) + 2;
     }

     private void swap(int first, int second){
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
     }

     public void insert(T value){
        // insert a last -
         list.addLast(value);
         // do upheap -
         upHeap(list.size()-1);
     }

     private void upHeap(int index){
        if(index==0) return; // reached the root

        int p = parent(index);
        if(list.get(p).compareTo(list.get(index))>0){
            swap(p, index);
            upHeap(p);
        }
     }

     public T remove() throws Exception{
        if(list.isEmpty()) {
            throw new Exception("Cannot remove from an empty list");
        }

        T item = list.get(0);
        T last = list.remove(list.size()-1);

        if(!list.isEmpty()){
            list.set(0, last);
            // do downheap -
            downHeap(0);
        }
        return item;
     }

     private void downHeap(int index){
        int min = index;
        int left = left(index);
        int right = right(index);

        if(left < list.size() && list.get(min).compareTo(list.get(left))>0){
            min = left;
        }
        if(right < list.size() && list.get(min).compareTo(list.get(right))>0){
            min = right;
        }

        if(min!=index){
            swap(min, index);
            downHeap(min);
        }
     }

     public ArrayList<T> heapSort() throws Exception{
        ArrayList<T> sorted = new ArrayList<>();
        while(!list.isEmpty()){
            sorted.add(this.remove());
        }
        return sorted;
     }
}
