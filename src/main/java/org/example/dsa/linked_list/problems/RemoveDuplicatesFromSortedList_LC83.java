package org.example.dsa.linked_list.problems;

public class RemoveDuplicatesFromSortedList_LC83 {

    /** Given the head of a sorted linked list, delete all duplicates such that
     *  each element appears only once. Return the linked list sorted as well.
     * **/
    public static ListNode deleteDuplicates(ListNode head) {
        return deleteDuplicatesRec(head);
    }

    private static ListNode deleteDuplicatesRec(ListNode currentNode){
        if(currentNode == null){ // in case the list is empty
            return currentNode;
        }
        // base condition - when we reach the end -
        if(currentNode.next == null){
            return currentNode;
        } else{
            ListNode nextNode = currentNode.next;
            if(currentNode.val == nextNode.val){
                currentNode.next = nextNode.next;
                nextNode.next = null;
                return deleteDuplicatesRec(currentNode);
            } else{
                currentNode.next = deleteDuplicates(currentNode.next);
                return currentNode;
            }
        }
    }

    private static ListNode deleteDupes(ListNode head){
        if(head == null){
            return head;
        }
        ListNode currentNode = head;
        while(currentNode.next != null){
            if(currentNode.val == currentNode.next.val){
                currentNode.next = currentNode.next.next;
            }else{
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    public static void displayList(ListNode head){
        ListNode temp = head;
        while (temp!= null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args){
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(3);
        node.next = node1;
        node1.next = node2;
        node2.next = null;
//        node3.next = node4;
//        node4.next = null;

        ListNode result = deleteDupes(node);
        displayList(result);
    }

}
