package com.dhemery.configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * A cache backed by a {@link java.util.HashMap}.
 * @param <K> the type of key.
 * @param <V> the type of value.
 */
public class MappedCache<K, V> implements Cache<K,V>{
    private final Map<K,V> valuesByKey = new HashMap<K,V>();

    @Override
    public V value(K key, V defaultValue) {
        if(!valuesByKey.containsKey(key)) valuesByKey.put(key, defaultValue);
        return valuesByKey.get(key);
    }

    @Override
    public V value(K key, CacheSource<K, V> source) {
        if(!valuesByKey.containsKey(key)) valuesByKey.put(key, source.value(key));
        return valuesByKey.get(key);
    }
}
