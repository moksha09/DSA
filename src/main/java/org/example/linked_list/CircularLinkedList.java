package org.example.linked_list;

public class CircularLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public CircularLinkedList(){
        this.size = 0;
    }

    public void displayCLL(){
        Node temp = head;
        do{
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }while(temp != head);
    }

    public void insertAtFirst(int value){
        Node newNode = new Node(value);
        if(head==null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void delete(int value){
        Node temp = head;
        if(temp == null){
            return;
        }
        if(temp.value == value){
            head = head.next;
            tail.next = head;
            return;
        }
        do {
            Node n = temp.next;
            if(n.value == value){
                temp.next = n.next;
                break;
            }
            temp = temp.next;
        } while(temp != head);
    }

    public void deleteFirst(){
        Node temp = head.next;
        tail.next = temp;
        head = temp;
        size--;
    }


    private class Node{
        private Node next;
        private int value;

        public Node(int value){
            this.value = value;
        }
    }
}
