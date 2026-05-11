package org.example.linked_list.problems;

public class LinkedListCycleII_LC142 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // MEDIUM -

    /**
     * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
     *
     * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
     * following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
     * is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
     *
     * Do not modify the linked list.
     * @param head
     * @return
     */

    // STEPS -
    // 1) Find the length of cycle.
    // 2) Move the slow pointer ahead to length size
    // 3) move the fast pointer starting at head and slow pointer one by one.
    // 4) Wherever they meet would be the head
    public ListNode detectCycle(ListNode head) {
        int length = getCycleLength(head);

        if(length == -1) return null;

        ListNode s1 = head;
        ListNode s2 = head;

        while (length!=0){
            s1 = s1.next;
            length--;
        }
        while(s1!=s2){
            s2 = s2.next;
            s1 = s1.next;
        }

        return s1;

    }

    public int getCycleLength(ListNode head){
        if(head==null || head.next==null) return -1;

        ListNode sp = head;
        ListNode fp = sp.next;

        while(sp!=null && fp!=null && fp.next!=null){
            if(sp==fp){
                int length = 0;
                do{
                    length++;
                    sp = sp.next;
                }while(sp!=fp);
                return length;
            }
            sp = sp.next;
            fp = fp.next.next;
        }
        return -1;

    }

    private static ListNode getNode(int index, ListNode head){
        ListNode temp = head;
        while(index!=0){
            temp = temp.next;
            index--;
        }
        return temp;
    }

    public static void main(String[] args){

    }
}
