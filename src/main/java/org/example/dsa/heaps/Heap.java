package org.example.dsa.heaps;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
    // Implementing MinHeap
    // extending Comparable so that we can compare 2 objects
    private ArrayList<T> list;
    public Heap() {
        this.list = new ArrayList<>();
    }

    private void swap(int firstIndex, int secondIndex){
        T temp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);
    }

    private int parent(int index){
        return (index-1)/2;
    }
    private int left(int index){
        return (index*2) + 1;
    }
    private int right(int index){
        return (index*2) + 2;
    }

    public void insert(T value){
        // first put the element at last -
        list.addLast(value);
        // call upheap from the last index -
        upHeap(list.size()-1);

    }

    private void upHeap(int index){
        if(index==0) return;

        int p = parent(index);
        if(list.get(index).compareTo(list.get(p))<0) {
            swap(index, p);
            upHeap(p);
        }
    }

    public T remove() throws Exception {
        if(list.isEmpty()){
            throw new Exception("Removing from an empty heap!");
        }

        T temp = list.get(0); // the item we are removing
        T last = list.remove(list.size()-1);  // the last item
        if(!list.isEmpty()){
            list.set(0, last); // add it to start
            // do a downheap -
            downHeap(0);
        }
        return temp;
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
        ArrayList<T> data = new ArrayList<>();
        while(!list.isEmpty()){
            data.add(this.remove());
        }
        return data;
    }
}
