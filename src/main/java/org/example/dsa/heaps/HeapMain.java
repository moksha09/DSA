package org.example.dsa.heaps;

import java.util.ArrayList;
import org.example.dsa.heaps.practise.MaxHeap;
import org.example.dsa.heaps.practise.MinHeap;

public class HeapMain {

    public static void main(String[] args) throws Exception{
        MinHeap<Integer> heap = new MinHeap<>();

        heap.insert(34);
        heap.insert(45);
        heap.insert(22);
        heap.insert(89);
        heap.insert(76);

        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());

        ArrayList list = heap.heapSort();
        System.out.println(list);

        MaxHeap<Integer> heap1 = new MaxHeap<>();

        heap1.insert(34);
        heap1.insert(45);
        heap1.insert(22);
        heap1.insert(89);
        heap1.insert(76);

        System.out.println(heap1.remove());
        System.out.println(heap1.remove());
        System.out.println(heap1.remove());
        System.out.println(heap1.remove());

        ArrayList list1 = heap1.heapSort();
        System.out.println(list1);
    }
}
