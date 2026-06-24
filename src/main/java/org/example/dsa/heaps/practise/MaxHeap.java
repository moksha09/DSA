package org.example.dsa.heaps.practise;

import java.util.ArrayList;

public class MaxHeap<T extends Comparable<T>> {

    ArrayList<T> list;

    public MaxHeap(){
        list = new ArrayList<>();
    }

    private int parent(int index){
        return (index-1)/2;
    }

    private int left(int index){
        return (2*index)+1;
    }

    private int right(int index){
        return (2*index)+2;
    }

    private void swap(int first, int second){
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    public void insert(T value){
        // add at the last -
        list.addLast(value);
        // do upHeap -
        upHeap(list.size()-1);
    }

    private void upHeap(int index){
        int p = parent(index);
        if(list.get(index).compareTo(list.get(p))>0){
            // swap -
            swap(index, p);
            upHeap(p);
        }
    }

    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("cannot remove item from empty list");
        }

        T item = list.get(0);
        T last = list.remove(list.size()-1);

        if(!list.isEmpty()){
            list.set(0, last);
            // do downHeap -
            downHeap(0);
        }
        return item;
    }

    private void downHeap(int index){
        int max = index;
        int left = left(index);
        int right = right(index);

        if(left<list.size() && list.get(max).compareTo(list.get(left))<0){
            max = left;
        }

        if(right<list.size() && list.get(max).compareTo(list.get(right))<0){
            max = right;
        }

        if(max!=index){
            swap(index, max);
            downHeap(max);
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

