package org.example.dsa.heaps.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {
    /**
     * Given an integer array nums and an integer k, return the kth largest element in the array.
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     * Can you solve it without sorting?
     */

    // brut force - 1) Sort the array and get the element, 2) Use priority queue

    public int findKthLargestBrute(int[] nums, int k) {
        // Time complexity = O(N*logN)
        // Space Complexity = O(n)
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<nums.length; i++){
            queue.add(nums[i]);
        }
        for(int i=1; i<k; i++){
            queue.remove();
        }
        return queue.peek();
    }

    // optimized - you only need k elements in your priority queue
    // logic - kth largest element = min of the k largest elements of the array;
    public int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums){
            minHeap.offer(num);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
