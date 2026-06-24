package org.example.dsa.linked_list;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public void displayList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " - ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void displayInReverse() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.value + " - ");
            temp = temp.prev;
        }
        System.out.println("END");
    }

    public void insertAtFirst(int value) {
        // create a new temp node -
        Node temp = new Node(value);
        temp.next = head;
        temp.prev = null;
        if (head == null) { // for empty ll
            tail = temp;
        } else {
            head.prev = temp;
        }
        head = temp;
        size++;
    }

    public void insertAtLast(int value) {
        if (size == 0) {
            insertAtFirst(value);
        } else {
            Node temp = new Node(value);
            tail.next = temp;
            temp.prev = tail;
            temp.next = null;
            tail = temp;
            size++;
        }
    }

    public void insertAtIndex(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            insertAtFirst(value);
            return;
        }

        if (index == size) {
            insertAtLast(value);
            return;
        }

        Node prevNode = getNodeAtIndex(index - 1);
        Node nextNode = prevNode.next;
        Node newNode = new Node(value);

        nextNode.next = newNode;
        newNode.prev = nextNode;
        newNode.next = nextNode;
        nextNode.prev = newNode;
        size++;
    }

    public void insertAfterAValue(int after, int value){
        if(after == tail.value){
            insertAtLast(value);
        }
        Node prevNode = getNodeFromValue(after);
        Node nextNode = prevNode.next;
        Node newNode = new Node(value);

        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = nextNode;
        nextNode.prev = newNode;

        size++;

    }

    public int removeFirst(){
        int value = head.value;
        Node temp = head.next;
        if(temp!=null){
            head = temp;
            head.prev = null;
        } else{
            head = null;
            tail = null;
        }
        size--;
        return value;
    }

    public int removeLast(){
        int value = tail.value;
        Node temp = tail.prev;
        if(temp != null){
            tail = temp;
            tail.next = null;
        }else{
            tail = null;
            head = null;
        }
        size--;
        return value;
    }

    public int removeNodeAtIndex(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }

        if(index == 0){
            return removeFirst();
        } else if(index == size-1){
            return removeLast();
        }else{
            Node temp = getNodeAtIndex(index);
            int value = temp.value;
            Node prevNode = temp.prev;
            Node nextNode = temp.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
            return value;
        }
    }

    public Node getNodeAtIndex(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node getNodeFromValue(int value){
        Node temp = head;
        while(temp != null){
            if(temp.value == value){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // REVERSE LIST -
    public void reverseDLL(){
        Node temp = head;
        head = tail;
        tail = temp;
    }

    // CONVERT INTO CIRCULAR -
    public void convertIntoCircular(){
        head.prev = tail;
        tail.next = head;

        Node temp1 = head;
        do {
            System.out.print(temp1.value + " -> ");
            temp1 = temp1.next;
        }while(temp1 != head);

        System.out.println();
    }

    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

    }
}
