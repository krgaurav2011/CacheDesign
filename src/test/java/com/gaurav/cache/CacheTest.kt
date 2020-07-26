package com.gaurav.cache

import com.gaurav.cache.Factories.CacheFactory
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class CacheTest {
    lateinit var cache: Cache<Int, Int>

    @BeforeEach
    fun setup() {
        cache = CacheFactory<Int, Int>().defaultCache(3)
    }

    @Test
    fun addAndEvictTest() {
        cache.put(1, 1)
        cache.put(2, 2)
        assertEquals(cache.get(1), 1)
        cache.put(3, 3)
        cache.put(4, 4)
        assertEquals(cache.get(2), null)
        cache.put(2, 222)
    }
}