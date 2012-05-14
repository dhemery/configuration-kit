package com.dhemery.configuration;

/**
 * A caching repository of values accessible by key.
 * @param <K> the type of key used to access values.
 * @param <V> the type of value.
 */
public interface Cache<K, V> {
    /**
     * Returns the value associated with a key.
     * If the cache has no value for the key,
     * the cache stores {@code defaultValue}
     * and returns it.
     * @param key the key whose value to return.
     * @param defaultValue the value to associate with {@code key} if no value is already associated.
     * @return the value associated with {@code key}.
     */
    V value(K key, V defaultValue);

    /**
     * Returns the value associated with a key.
     * If the cache has no value for the key,
     * the cache obtains a value from {@code source},
     * stores the obtained value,
     * and returns it.
     * @param key the key whose value to return.
     * @param source a source that can provide a value for key.
     * @return the value associated with {@code key}.
     */
    V value(K key, CacheSource<K, V> source);
}
