package com.dhemery.configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * A set of configuration options.
 */
public class Configuration {
    private final Map<String, String> options = new HashMap<String, String>();

    /**
     * Create a {@code Configuration} with no options defined.
     */
    public Configuration() {
    }

    /**
     * Create a {@code Configuration} with options copied from a {@link Map}.
     * @param options a map that defines options.
     */
    public Configuration(Map<String, String> options) {
        this.options.putAll(options);
    }

    /**
     * Create a configuration with options read from properties files.
     * @param filenames the names of the files from which to read options.
     */
    public Configuration(String... filenames) {
        this(ReadProperties.fromFiles(filenames).asMap());
    }

    /**
     * Create a configuration with the options copied from another configuration.
     * @param other the configuration from which to copy options.
     */
    public Configuration(Configuration other) {
        this(other.options);
    }

    /**
     * @param name the name of an option.
     * @return whether this configuration defines a value for the option.
     */
    public Boolean defines(String name) {
        return options.containsKey(name);
    }

    /**
     * Merge a set of configuration options into this configuration.
     * If both configurations have values for an option,
     * this configuration's value is replaced by the value from the other configuration.
     *
     * @param other a set of configuration options.
     */
    public void merge(Configuration other) {
        options.putAll(other.options);
    }

    /**
     * @param name the name of an option.
     * @return the value of the option, or nil if the configuration has no value for the option.
     */
    public String option(String name) {
        return options.get(name);
    }

    /**
     * Supply a value for an option.
     * If the configuration already has a value for the option,
     * the old value is replaced by the given value.
     *
     * @param name  the name of the option.
     * @param value the value for the option.
     */
    public void set(String name, String value) {
        options.put(name, value);
    }
}
