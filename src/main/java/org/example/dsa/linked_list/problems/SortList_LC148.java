package org.example.dsa.linked_list.problems;


// LEETCODE MEDIUM -
public class SortList_LC148 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {};
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Sort in ascending order -
    // Lets use merge sort for this - 
    // logic behind merge sort is that we divide the list in 2 parts sort them and then merge them
    // this is done recursively - 
    
    public ListNode sortList(ListNode head) {
        // base condition -
        if(head==null || head.next == null){
            return head;
        }
        // get the middle element -
        ListNode middle = getMiddle(head);
        ListNode rightNode = middle.next;
        middle.next = null;

        // sort each part
        ListNode left = sortList(head);
        ListNode right = sortList(rightNode);

        // merge them -
        return merge(left, right);
    }

    public ListNode getMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    ListNode merge(ListNode list1, ListNode list2){

        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        while(list1!=null && list2!=null){
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
}
