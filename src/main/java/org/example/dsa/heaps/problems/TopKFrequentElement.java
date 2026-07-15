package org.example.dsa.heaps.problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement {
    /**
     * Given an integer array nums and an integer k, return the k most frequent elements.
     * You may return the answer in any order.
     *
     * TC = better than O(nlogn)
     *
     * [ 1, 2, 2, 1, 4, 3, 3, 1], K=2
     *
     * map = {
     *     {1, 3},
     *     {2, 2},
     *     {3, 2},
     *     {4, 1}
     * }
     */

    public static int[] topKFrequent(int[] nums, int k) {

        // Store the elements in hashmap with there frequency;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            int value = map.getOrDefault(num, 0);
            map.put(num, value+1);
        }


        // Store the entry from hashmap to priority queue with comparator as the frequency -
        Comparator<Map.Entry<Integer, Integer>> comparator = (a, b) -> {
            return a.getValue()- b.getValue();
        };
        int[] result = new int[k];
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Map.Entry.comparingByValue());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        for(int i=0; i<k; i++){
            result[i] = minHeap.poll().getKey();
        }
        return result;

    }

    public static void main(String[] args){
        int[] nums = new int[] {1,1,2,4,3,2,1};
        topKFrequent(nums, 2);
    }
}
