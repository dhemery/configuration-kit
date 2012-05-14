package com.dhemery.configuration;

/**
 * A {@link MappedCache} that can obtain values from a single source.
 * @param <K> the type of key.
 * @param <V> the type of value.
 */
public class SingleSourceMappedCache<K,V> extends MappedCache<K,V> {
    private final CacheSource<K, V> defaultSource;

    /**
     * Create a cache with a default source.
     * @param defaultSource the default source of values.
     * @see #value(Object)
     */
    public SingleSourceMappedCache(CacheSource<K, V> defaultSource) {
        this.defaultSource = defaultSource;
    }

    /**
     * Returns the value associated with a key.
     * If the cache has no value for the key,
     * the cache obtains a value from the cache's {@code defaultSource},
     * stores the obtained value,
     * and returns it.
     * @param key a key.
     * @return the value associated with {@code key}.
     */
    public V value(K key) {
        return value(key, defaultSource);
    }
}
