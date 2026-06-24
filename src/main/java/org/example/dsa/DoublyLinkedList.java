package org.example.dsa;

import java.util.Iterator;

public class DoublyLinkedList <T> implements Iterable <T> {

    private int size = 0;
    private Node <T> head = null;
    private Node <T> tail = null;

    //interanl Node class to implement data -
    private class Node <T> {
        T data;
        Node<T> prev, next;
        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        @Override
        public String toString() {
            return data.toString();
        }
    }

    //Empty this linked list, O(n) - going through all the elements and deallocating them by setting them to null, one at a time
    public void clear() {
        Node <T> trav = head;
        while(trav != null){
            Node <T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    //return the sixe of linked list
    public int size(){ return size;}

    //is the linked list empty? -
    public boolean isEmpty(){ return size == 0;}

    //Add an element to the tail os liked list - O(1) -
    public void add(T elem){
        addLast(elem);
    }

    //Add an element to the beginning of LL -
    public void addFirt(T elem){

        if(isEmpty()){
            head = tail =new Node<T> (elem, null, null);
        } else {
            head.prev = new Node<T> (elem, null, head);
            head = head.prev;
        }
        size++;
    }

    // Add a node at the last of a LL -
    public void addLast(T elem){

        if(isEmpty()) {
            head = tail = new Node<T> (elem, null, null);
        } else {
            tail.next = new Node<T> (elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    // Check the value of the first node if it exists, O(1) -
    public T peekFirst() {
        if(isEmpty()) throw new RuntimeException("Empty List");
        return head.data;
    }

    // Check the value of Last Node it exists O(1) -
    public T peekLast() {
        if(isEmpty()) throw new RuntimeException("Empty List");
        return tail.data;
    }

    // Remove the head of the Linked List, O(1) -
    public T removeFisrt(){
        if(isEmpty()) throw new RuntimeException("Empty List");
        T rem_elem = head.data;
        head = head.next;
        --size;
        if(isEmpty()) tail = null;
        head.prev = null;
        return rem_elem;
    }

    // Remove last
    public T removeLast() {
        if(isEmpty()) throw new RuntimeException("List is empty");

        T rem_elem = tail.data;
        tail = tail.prev;
        size--;
        if(isEmpty()) head = null;
        tail.next = null;
        return rem_elem;
    }

    // Remove an arbitrary node from linked list, O(1) -
    private T remove(Node <T> node) {
        // If the node to remove is eithre at head or tail hadle it imdependently
        if(node.prev ==null) removeFisrt();
        if(node.next ==null) removeLast();

        node.next.prev = node.prev;
        node.prev.next = node.next;

        T data = node.data;

        //memory cleanup -
        node.data = null;
        node = node.prev = node.next = null;

        --size;

        return data;
    }

    //Remove a node at particular index =
    public T removeAt(int index) {

        // Make sure the index provided is valid -
        if(index<0 || index>=size) throw new IllegalArgumentException();

        int i;
        Node <T> trav;

        if(index<size/2) {
            for (i = 0, trav = head; i != index; i++) {
                trav = trav.next;
            }
        }
            else {
                for(i=size-1, trav = tail; i!=index; i--){
                    trav = trav.prev;
                }
            }
            return remove(trav);
        }

    //Remove a particular value in Linked list -O(n)
    public boolean remove(Object obj) {

        Node<T> trav = head;

        //searching for null
        if(obj == null){
            for(trav = head; trav !=null; trav = trav.next){
                if(trav.data == null){
                    remove(trav);
                    return true;
                }
            }
        } else {
            for(trav = head; trav != null; trav = trav.next) {
                if(obj.equals(trav.data)) {
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }

    // Find the index of a particular value in LL - O(n) -
    public int indexOf(Object obj){
        int index=0;
        Node<T> trav = head;

        if(obj == null) {
            for(trav=head; trav!=null; trav=trav.next){
                if(trav.data == null){
                    return index;
                }
            }
        } else {
            for(trav=head; trav!=null; trav=trav.next){
                if(obj.equals(trav.data)){
                    return index;
                }
            }
        }
        return -1;
    }

    // Check if a value is contained within the LL -
    public boolean contains(Object obj) {
        return indexOf(obj)!= -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> trav = head;
            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }
}
