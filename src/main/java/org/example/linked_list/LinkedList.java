package org.example.linked_list;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.size = 0;
    }

    public void displaySinglyLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void insertAtFirst(int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;

        if (tail == null) { // if it's an empty linked list
            tail = head;
        }

        size++;
    }

    public void insertAtLast(int val) {
        if (tail == null) {
            insertAtFirst(val);
        } else {
            Node temp = new Node(val);
            tail.next = temp;
            tail = temp;
            size++;
        }
    }

    // inserting at a particular index -
    public void insertAtIndex(int index, int value) {
        if (index == 0) {
            insertAtFirst(value);
        } else if (index == size - 1) {
            insertAtLast(value);
        } else {
            Node temp1 = getNodeAtIndex(index - 1);
            Node temp2 = new Node(value);
            temp2.next = temp1.next;
            temp1.next = temp2;
            size++;
        }

    }

    // insert using recursion -
    // WHen doing recursion in linked list we have 2 obvious observations -
    // 1) have a void return type and make changes in LL
    // 2) Have a node return type that returns the list node to change the structure

    public void insertRec(int index, int value) {
        head = insertRecursion(index, value, head);
    }

    private Node insertRecursion(int index, int value, Node currentNode) { // making the recursive function as private as we don't want it to be seen
        // base condition index == 0
        if (index == 0) {
            // create a new node and add it
            Node newNode = new Node(value);
            newNode.next = currentNode;
            size++;
            return newNode;
        }

        currentNode.next =  insertRecursion(index-1, value, currentNode.next);
        return currentNode;
    }

    public Node getNodeAtIndex(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // deletion in singly linked list -

    public int removeFirst() {
        int value = head.value;
        head = head.next;
        if (head == null) tail = null; // for list with just one element
        size--;
        return value;
    }

    public int removeLast() {
        int value = tail.value;
        if (size <= 1) {
            removeFirst();
        }
        tail = getNodeAtIndex(size - 2); // take the 2nd last item and make it equal to tail
        tail.next = null;
        size--;
        return value;
    }

    public int removeAtIndex(int index) {
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node temp1 = getNodeAtIndex(index - 1);
            Node temp2 = temp1.next;
            int value = temp2.value;

            temp1.next = temp2.next;
            temp2.next = null;

            size--;
            return value;
        }
    }

    public Node findNodeWithValue(int value) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value == value) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }
}
