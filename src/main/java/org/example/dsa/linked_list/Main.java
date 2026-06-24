package org.example.dsa.linked_list;


public class Main {

    public static void main(String[] args){

        // SINGLY LINKED LIST
        LinkedList linkedList = new LinkedList(); // size is initialized to 0
        linkedList.insertAtFirst(1);
        linkedList.insertAtFirst(3);
        linkedList.insertAtFirst(2);
        linkedList.insertAtFirst(8);
        linkedList.insertAtLast(99);
        linkedList.insertAtIndex(3,88);
        linkedList.removeAtIndex(3);
        linkedList.insertRec(2,77);
        linkedList.displaySinglyLinkedList();

        // DOUBLY LINKED LIST
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertAtFirst(1);
        doublyLinkedList.insertAtFirst(2);
        doublyLinkedList.insertAtFirst(3);
        doublyLinkedList.insertAtFirst(4);
        doublyLinkedList.insertAtLast(99);
        doublyLinkedList.insertAtIndex(5, 101);
//        doublyLinkedList.displayList();

        // CIRCULAR LINKED LIST
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.insertAtFirst(3);
        circularLinkedList.insertAtFirst(2);
        circularLinkedList.insertAtFirst(1);
//        circularLinkedList.displayCLL();

        // problems -



    }
}
