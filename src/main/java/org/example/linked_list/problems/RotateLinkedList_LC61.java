package org.example.linked_list.problems;

public class RotateLinkedList_LC61 {

    // MEDIUM -
    /**
     * Given the head of a linked list, rotate the list to the right by k places.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k<=0 || head.next==null){
            return head;
        }
        // get the length of the linked list -
        ListNode temp1 = head;
        int length = 1;
        while(temp1.next != null){
            length++;
            temp1 = temp1.next;
        }

        // temp1 is at lastNode
        // traverse to (length-k)th node -
        ListNode temp2 = head;
        for(int i=0; i<(length-k) && temp2!=null; i++){
            temp2 = temp2.next;
        }

        // now rearrange -
        ListNode newHead = temp2.next;
        temp2.next = null;
        temp1.next = head;

        return newHead;
    }
}
