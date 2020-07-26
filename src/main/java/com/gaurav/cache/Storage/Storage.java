package com.gaurav.cache.Storage;

import com.gaurav.cache.Exceptions.NotFoundException;
import com.gaurav.cache.Exceptions.StorageFullException;

public interface Storage<Key, Value> {
    void put(Key k, Value v) throws StorageFullException;

    Value get(Key k) throws NotFoundException;

    void remove(Key k) throws NotFoundException;
}
