package org.example.dsa.heaps.problems;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    /**
     * The median is the middle value in an ordered integer list. If the size of the list is even,
     * there is no middle value, and the median is the mean of the two middle values.
     *
     * For example, for arr = [2,3,4], the median is 3.
     * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
     * Implement the MedianFinder class:
     *
     * MedianFinder() initializes the MedianFinder object.
     * void addNum(int num) adds the integer num from the data stream to the data structure.
     * double findMedian() returns the median of all elements so far. Answers within 10^(-5) of the actual answer will be accepted.
     */

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;


    public FindMedianFromDataStream() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num){
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }
        // resize
        if(maxHeap.size()-minHeap.size()>1){
            minHeap.offer(maxHeap.remove());
        }
        if(maxHeap.size() - minHeap.size()<-1 ){
            maxHeap.offer(minHeap.remove());
        }
    }


    public double findMedian(){
        if(minHeap.size() == maxHeap.size()){
            return (double) (minHeap.peek() + maxHeap.peek()) /2;
        }else{
            return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
        }
    }
}
