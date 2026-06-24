package org.example.dsa.linked_list.problems;

public class ReverseLinkedListII_LC92 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // MEDIUM -

    /**
     * Given the head of a singly linked list and two integers left and right
     * where left <= right, reverse the nodes of the list from position left
     * to position right, and return the reversed list.
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right) return head;

        // skip the first left-1 nodes - present will start from head and prev will start from null -
        ListNode current = head;
        ListNode previous = null;
        // traverse to the start of the section
        for(int i=0; current!=null && i<left-1; i++){
            previous = current;
            current = current.next;
        }

        // save the last node and the last +1 node which would be used at end to connect the whole thing
        ListNode last = previous;
        ListNode newEnd = current;

        // reverse between left and right -
        ListNode next = current.next;
        for(int i=0; current!=null && i<right-left+1; i++){
            current.next = previous;
            previous = current;
            current = next;
            if(next!=null){
                next = next.next;
            }
        }

        // connect the ends to the reversed list to form the result =
        if(last!=null){
            last.next = previous;
        }else{
            head = previous;
        }
        newEnd.next = current;
        return head;
    }

    public static void main(String[] args){
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = null;

        ListNode result = reverseBetween(p1, 1, 4);

        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
