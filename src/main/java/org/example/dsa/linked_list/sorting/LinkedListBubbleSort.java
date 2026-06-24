package org.example.dsa.linked_list.sorting;


public class LinkedListBubbleSort {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void bubbleSort(ListNode head) {

        if(head==null) return;

        boolean isSwapped;

        do{
            isSwapped = false;
            ListNode curr = head;

            while(curr.next!=null){
                if(curr.val>curr.next.val){
                    // swap values -
                    int temp = curr.val;
                    curr.val = curr.next.val;
                    curr.next.val = temp;

                    isSwapped = true;
                }
                curr = curr.next;
            }
        } while(isSwapped);

    }

    public static void bubbleSortRecursion(ListNode head, int n){
        if(n==1) return;
        if (head==null) return;

        ListNode curr = head;
        for(int i=0; i<n-1; i++){
            if(curr.val>curr.next.val){
                //swap -
                int temp = curr.val;
                curr.val = curr.next.val;
                curr.next.val = temp;
            }
            curr = curr.next;
        }

        bubbleSortRecursion(head, n-1);
    }
    // you can write a method to get length to use in n as argument

    public static ListNode bubbleSortSwapNodes(ListNode head){
        if(head == null || head.next==null) return head;

        boolean isSwapped;

        do{
            isSwapped = false;
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode prev = dummy;
            ListNode curr = head;

            while(curr.next != null){
                if(curr.val>curr.next.val){
                    //swap the whole node -
                    ListNode next = curr.next;
                    curr.next = next.next;
                    next.next = curr;
                    prev.next = next;

                    isSwapped = true;

                    prev = next;
                }else{
                    prev = curr;
                    curr = curr.next;
                }
            }
            head = dummy.next;
        }while(isSwapped);
        return head;
    }

    public static void main(String[] args){
        ListNode p1 = new ListNode(4);
        ListNode p2 = new ListNode(3);
        ListNode p3 = new ListNode(1);
        ListNode p4 = new ListNode(2);
        ListNode p5 = new ListNode(5);

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = null;

        ListNode head = bubbleSortSwapNodes(p1);

       while(head!=null){
           System.out.println(head.val);
           head = head.next;
       }


    }



}
