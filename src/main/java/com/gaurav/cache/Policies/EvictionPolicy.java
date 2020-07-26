package com.gaurav.cache.Policies;

public interface EvictionPolicy<Key> {
    void keyAccessed(Key key);

    Key evictKey();
}
