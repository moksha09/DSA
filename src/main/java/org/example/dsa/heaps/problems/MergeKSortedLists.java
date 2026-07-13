package org.example.dsa.heaps.problems;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import org.example.dsa.linked_list.MergeSort;

public class MergeKSortedLists {
    /**
     * You are given an array of k linked-lists lists,
     * each linked-list is sorted in ascending order.
     *
     * Merge all the linked-lists into one sorted linked-list and return it.
     */

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) {
            this.val = val;
            next = null;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;

        }
    }
    // Brute force -
    // Combine all lists into a single list and sort it
    // Optimized - Algo -
    // 1) Create a minHeap of ListNode,
    // 2) Store the first element/node from each list in the minHeap,
    // 3) While the minHeap is not empty -
    //      - Remove the top element from heap and append it to result
    //      - If the next element is not null then add the next element to the minHeap
    // 4) return the result
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        int k = lists.length;
        for(int i=0; i<k; i++){
            if(lists[i] != null){
                minHeap.offer(lists[i]);
            }
        }

        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            tail.next = node;
            tail = tail.next;
            if(node.next != null){
                minHeap.offer(node.next);
            }
        }
        return dummy.next;
    }
}
