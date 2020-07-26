package com.gaurav.cache.DataStructure;

public class DoublyLinkedListNode<E> {
    DoublyLinkedListNode<E> next;
    DoublyLinkedListNode<E> prev;
    E element;

    public E getElement() {
        return element;
    }

    public DoublyLinkedListNode(E element){
        this.next = null;
        this.prev = null;
        this.element = element;
    }
}
