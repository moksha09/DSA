package org.example.dsa.linked_list;

public class MergeSort {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // given 2 sorted list - you need to merge them is sorted manner -
    // logic -
    // 1) put 2 temp nodes at the head of each list
    // 2) Compare  the value of each node whichever is the smaller one
    // add it to the result
    ListNode merge(ListNode list1, ListNode list2){

        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        while(list1!=null &list2!=null){
            if(list1.val< list2.val){ // if l1 is smaller connect the tail to its answer =
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else{
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1!=null)?list1:list2;
        return dummyHead.next;
    }

    public ListNode getMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
