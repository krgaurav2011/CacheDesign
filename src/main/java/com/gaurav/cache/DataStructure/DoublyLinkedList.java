package com.gaurav.cache.DataStructure;

public class DoublyLinkedList<E> {
    private DoublyLinkedListNode<E> head =null;
    private DoublyLinkedListNode<E> tail = null;

    public DoublyLinkedListNode<E> getHead() {
        return head;
    }

    public DoublyLinkedListNode<E> getTail() {
        return tail;
    }

    public void detachNode(DoublyLinkedListNode<E> node)  {
        if(node == null)
            return;
        if(node.equals(head)){
            head = head.next;
            if(head != null) head.prev = null;
        }
        else if(node.equals(tail)){
            tail = tail.prev;
            if(tail != null) tail.next = null;
        }

        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void addToFront(DoublyLinkedListNode<E> node)  {
        if(node == null) return;
        if(head != null) {
            head.prev = node;
            node.next = head;
            node.prev = null;
        }else {
            tail = node;
        }
        head = node;
    }
    public DoublyLinkedListNode<E> addElementToFront(E element){
        DoublyLinkedListNode<E> node = new DoublyLinkedListNode<E>(element);
        addToFront(node);
        return node;
    }
}
