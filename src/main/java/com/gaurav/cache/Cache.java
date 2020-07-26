package com.gaurav.cache;

import com.gaurav.cache.Exceptions.NotFoundException;
import com.gaurav.cache.Exceptions.StorageFullException;
import com.gaurav.cache.Policies.EvictionPolicy;
import com.gaurav.cache.Storage.Storage;

public class Cache<Key, Value> {

    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value) {
        try {
            storage.put(key, value);
        } catch (StorageFullException e) {
            System.out.println("Storage full, evicting..");
            Key removedKey  = evictionPolicy.evictKey();
            if(removedKey == null) throw new RuntimeException("Unexpected State");
            storage.remove(removedKey);
            put(key,value);
        }
        evictionPolicy.keyAccessed(key);
    }

    public Value get(Key k){
        try {
            Value v = storage.get(k);
            evictionPolicy.keyAccessed(k);
            return v;
        }catch (NotFoundException e){
            System.out.println("Not found");
            return null;
        }

    }
}
