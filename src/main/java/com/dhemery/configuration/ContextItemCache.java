package com.dhemery.configuration;

/**
 * A cache of {@code String}s keyed by {@link ContextItem}.
 */
public class ContextItemCache {
    private final SingleSourceMappedCache<ContextItem,String> cache;

    /**
     * @param source the source from which to seek values that are not yet stored in the cache.
     */
    public ContextItemCache(CacheSource<ContextItem,String> source) {
        cache = new SingleSourceMappedCache<ContextItem, String>(source);
    }

    /**
     * Returns the value of the item identified by a name in a context.
     * If cache has no value for the item,
     * the cache obtains a value from the cache's source,
     * stores the value,
     * and returns it.
     * @param context the context in which the item occurs.
     * @param name the name of the item in its context.
     * @return the value of the item.
     */
    public String value(String context, String name) {
        return cache.value(new ContextItem(context, name));
    }
}
