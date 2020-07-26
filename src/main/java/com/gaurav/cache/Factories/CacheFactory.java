package com.gaurav.cache.Factories;

import com.gaurav.cache.Cache;
import com.gaurav.cache.Policies.LRUEvictionPolicy;
import com.gaurav.cache.Storage.HashMapStorage;

public class CacheFactory<Key, Value> {
    public Cache<Key, Value> defaultCache(int capacity){
        return new Cache<Key, Value>( new LRUEvictionPolicy<Key>(), new HashMapStorage<Key, Value>(capacity));
    }
}
