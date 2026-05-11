package org.example.linked_list.problems;

public class ReOrderList_LC143 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // MY APPROACH -
    // 1) Get the middle node
    // 2) Reverse the second half
    // 3) loop through the both list to create the new list

    public static void reorderList(ListNode head) {
        if(head==null || head.next==null) return;

        // 1) Get the middle node -
        ListNode middle = middleNode(head);
        // 2) Reverse the second half -
        ListNode headSecond = reverse(middle);
        ListNode headFirst = head;

        // 3) Rearrange -
        while(headFirst!=null && headSecond!=null){
            ListNode temp = headFirst.next;
            headFirst.next = headSecond;
            headFirst = temp;

            temp = headSecond.next;
            headSecond.next = headFirst;
            headSecond = temp;
        }

        // setting next of tail to null -
        if(headFirst!=null){
            headFirst.next = null;
        }

    }

    public static ListNode middleNode(ListNode head){
        ListNode f = head;
        ListNode s = head;
        while(f!=null && f.next!=null){
            f = f.next.next;
            s = s.next;
        }
        return s;
    }

    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode current = head;
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

        reorderList(p1);

        ListNode temp = p1;
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }



    }
}
