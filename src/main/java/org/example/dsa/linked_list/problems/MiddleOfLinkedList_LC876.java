package org.example.dsa.linked_list.problems;

public class MiddleOfLinkedList_LC876 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    /**
     * Given the head of a singly linked list, return the middle node of the linked list.
     * If there are two middle nodes, return the second middle node.
     */

    public static ListNode middleNode(ListNode head) {
        int size = getSize(head);
        int index = 0;
        if(size%2!=0){
            index = (size/2)-1;
        }else{
            index = (size/2);
        }
        ListNode result = head;
        while(index!=0){
            result = result.next;
            index--;
        }
        return result;
    }

    private static int getSize(ListNode head){
        ListNode temp = head;
        int size = 0;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        return size;
    }

    // middle node using cycle pattern - slow-fast pointer -

    public static ListNode getMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
