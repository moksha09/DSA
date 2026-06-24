package org.example.dsa.linked_list.problems;

public class ReverseNodesInKGroup_LC25 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
     * k is a positive integer and is less than or equal to the length of the linked list.
     * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
     *
     * You may not alter the values in the list's nodes, only nodes themselves may be changed.
     * @param head
     * @param k
     * @return
     */

    // wasnt able to do it - look into it again once you are more clearer and stronger in LL questions and concepts
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k<=1) return head;

        int left = 1;
        int right = 1;
        ListNode prev = null;
        ListNode current = head;

        while(true) {
            ListNode newTail = current;
            ListNode newHead = prev;
            ListNode next = current.next;

            // reverse -
            for(int i=0; i<k && current!=null; i++){
                current.next = prev;
                prev = current;
                current = next;
                if(next!=null){
                    next = next.next;
                }
            }

            if(newHead!=null){
                newHead.next = prev;
            }else{
                head.next = prev;
            }

            newTail.next = current;

        }
    }

    // check if kth node exists or not ? -
    public static ListNode kthNode(ListNode head, int k){
        ListNode start = head;
        for(int i=1; i<k; i++){
            if(start!=null){
                start = start.next;
            }else{
                return head;
            }
        }
        return start;
    }

    // practise - reverse a ll
    public static ListNode reverseList(ListNode head){
        if(head==null || head.next == null) return head;
        ListNode prev = head;
        ListNode current = head.next;
        ListNode next = current.next;
        while(current!=null){
            current.next = prev;
            prev = current;
            current = next;
            if(next!=null){
                next = next.next;
            }
        }
        return prev;
    }

    // reverse a part of ll -
    public static ListNode reversePart(ListNode head, int left, int right){
        if(head==null || head.next==null || left==right) return head;

        ListNode current = head;
        ListNode prev = null;

        for(int i=0; current!=null && i<left-1; i++){
            prev = current;
            current = current.next;
        }

        ListNode lastNode = prev;
        ListNode newEnd = current;

        ListNode next = current.next;
        for(int i=0; current!=null && i<right-left-1; i++){
            current.next = prev;
            prev = current;
            current = next;
            if(next!=null){
                next = next.next;
            }
        }

        if(lastNode!=null){
            lastNode.next = prev;
        } else{
            head.next = prev;
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

        ListNode result = kthNode(p1, 6);
        if(result!=null){
            System.out.println(result.val);
        }else{
            System.out.println("null");
        }
    }
}
