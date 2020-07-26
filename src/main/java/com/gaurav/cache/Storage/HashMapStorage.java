package com.gaurav.cache.Storage;

import com.gaurav.cache.Exceptions.NotFoundException;
import com.gaurav.cache.Exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<Key, Value> implements Storage<Key, Value> {
    private Map<Key, Value> map;
    private final int capacity;
    public HashMapStorage(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
    }

    private  boolean isCacheFull (){
        return map.size() == capacity;
    }

    public void put(Key k, Value v) throws StorageFullException {
        if(isCacheFull()) throw new StorageFullException("No space left");
        map.put(k, v);
    }

    public Value get(Key k) {
        if(!map.containsKey(k)) throw new NotFoundException("Not Found");
        return map.get(k);
    }

    public void remove(Key k) {
        if(!map.containsKey(k)) throw new NotFoundException("Not Found");
        map.remove(k);
    }
}
