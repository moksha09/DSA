package org.example.linked_list.problems;

public class ReverseALinkedList_LC206 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // ITERATIVELY -
    public static ListNode reverseLinkedListIterative(ListNode head){
        ListNode dummy = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = dummy;
            dummy = head;
            head = temp;
        }
        return dummy;
    }

    // RECURSIVELY -
    public static ListNode reverse(ListNode head){
        ListNode dummy = null;
        return reverseLinkedListRecursive(head, dummy);
    }
    public static ListNode reverseLinkedListRecursive(ListNode head, ListNode prev){
        // base condition -
        if(head==null) return prev;
        ListNode temp = head.next;
        head.next = prev;
        prev = head;
        head = temp;
        return reverseLinkedListRecursive(head, prev);
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

        ListNode result = reverse(p1);

        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
