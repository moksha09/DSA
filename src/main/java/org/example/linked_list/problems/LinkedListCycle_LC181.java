package org.example.linked_list.problems;

public class LinkedListCycle_LC181 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    /**
     * Given head, the head of a linked list, determine if the linked list has a cycle in it.
     * <p>
     * There is a cycle in a linked list if there is some node in the list that can be reached
     * again by continuously following the next pointer. Internally, pos is used to denote the index
     * of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
     * <p>
     * Return true if there is a cycle in the linked list. Otherwise, return false.
     *
     * @param head
     * @return
     */

    // CONCEPT - SLOW AND FAST POINTER
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slowP = head;
        ListNode fastP = slowP.next;

        while (fastP != null && slowP != null) {
            if (fastP == slowP) {
                return true;
            }
            fastP = fastP.next.next;
            slowP = slowP.next;
        }

        return false;
    }

    // FIND THE LENGTH OF THE CYCLE -
    public int lengthOfCycle(ListNode head){
        ListNode nodeInCycle = nodeInCycle(head);
        ListNode counter = nodeInCycle.next;
        int length = 0;
        while(counter!=nodeInCycle){
            length++;
            counter = counter.next;
        }
        return length+1;

    }

    public ListNode nodeInCycle(ListNode head){
        if(head == null) return null;

        ListNode sp = head;
        ListNode fp = sp.next;

        while(sp!=null && fp!=null && fp.next!=null){
            if(sp == fp){
                return sp;
            }

            sp = sp.next;
            fp = fp.next.next;
        }
        return null;
    }
}
