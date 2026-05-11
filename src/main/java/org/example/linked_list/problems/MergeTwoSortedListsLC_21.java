package org.example.linked_list.problems;

public class MergeTwoSortedListsLC_21 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * You are given the heads of two sorted linked lists list1 and list2.
     * Merge the two lists into one sorted list. The list should be made by
     * splicing together the nodes of the first two lists.
     *
     * Return the head of the merged linked list.
     * @param list1
     * @param list2
     * @return
     */

    // MY LOGIC -
    // We will take 2 pointers/references on each lists ->
    // we then compare both pointer value and add the least value to the result and increase its ref to next
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode node1 = list1;
        ListNode node2 = list2;

        ListNode result = new ListNode();
        ListNode rhead = result;

        while(node1!=null && node2!= null){

            if(node1.val <= node2.val){
                // insert
                result.next = new ListNode(node1.val);
                node1 = node1.next;
                result = result.next;
            } else{
                result.next = new ListNode(node2.val);
                node2 = node2.next;
                result = result.next;
            }
        }
        if(node1!=null){
            result.next = node1;
        }

        if(node2!=null){
            result.next = node2;
        }
        rhead = rhead.next;
        return rhead;
    }
}
