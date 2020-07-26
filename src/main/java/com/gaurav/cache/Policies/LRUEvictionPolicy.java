package com.gaurav.cache.Policies;

import com.gaurav.cache.DataStructure.DoublyLinkedList;
import com.gaurav.cache.DataStructure.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    private DoublyLinkedList<Key> list;
    private Map<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy() {
        list = new DoublyLinkedList<Key>();
        mapper = new HashMap<Key, DoublyLinkedListNode<Key>>();
    }

    public void keyAccessed(Key k) {
        if (mapper.containsKey(k)) {
            DoublyLinkedListNode<Key> node = mapper.get(k);
            list.detachNode(node);
            list.addToFront(node);
        } else {
            DoublyLinkedListNode<Key> x = list.addElementToFront(k);
            mapper.put(k, x);
        }
    }

    public Key evictKey() {
        DoublyLinkedListNode<Key> last = list.getTail();
        if (last == null) return null;
        list.detachNode(last);
        mapper.remove(last.getElement());
        return last.getElement();
    }
}
