package org.example.dsa.linked_list.problems;

public class PalindromeLinkedList_LC234 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // a list would be a palindrome if it's reverse would be the same as it is.

    // APPROACH -
    // 1) Find the middle of the linked list.
    // 2) Reverse the second half of the linked list.
    // 3) Compare the first half with the second half.
    // 4) Re-reverse the second half.

    public static boolean isPalindrome(ListNode head) {

        // Find the middle of the linked list -
        ListNode middle = middleNode(head);

        // Reverse the second half -
        ListNode headSecondHalf = reverse(middle);
        ListNode rereverseHead = headSecondHalf;

        // compare both halves -
        while(head!=null && headSecondHalf !=null){
            if(head.val!=headSecondHalf.val){
                break;
            }
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }
        reverse(rereverseHead);
        if(head==null ||headSecondHalf==null){
            return true;
        }else{
            return false;
        }
    }

    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        ListNode nextNode = current.next;
        while(current!=null){
            current.next = prev;
            prev = current;
            current = nextNode;
            if(nextNode!=null){
                nextNode = nextNode.next;
            }
        }
        return prev;

    }

    // find middle node using slow and fast pointer -
    public static ListNode middleNode(ListNode head){
        ListNode f = head;
        ListNode s = head;

        while(f!=null && f.next!=null){
            f = f.next.next;
            s = s.next;
        }
        return s;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(2);
        ListNode p4 = new ListNode(1);

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = null;

        ListNode temp = reverse(p1);

        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }

        System.out.println(isPalindrome(p1));
    }
}
