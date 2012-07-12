package com.dhemery.configuration;

import java.util.*;

/**
 * A set of configuration options.
 */
public class Configuration {
    private final Map<String, String> options = new HashMap<String, String>();

    /**
     * Create a configuration with no options defined.
     */
    public Configuration() {
    }

    /**
     * Create a configuration by copying options from a map.
     * @param map a set of options represented as a map.
     */
    public Configuration(Map<String, String> map) {
        options.putAll(map);
    }

    /**
     * Create a configuration by copying options from a property list.
     * @param properties a set of options represented as a property list.
     */
    public Configuration(Properties properties) {
        for(String propertyName : properties.stringPropertyNames()) {
            options.put(propertyName, properties.getProperty(propertyName));
        }
    }

    /**
     * Create a configuration by copying options from another configuration.
     * @param other the configuration from which to copy options.
     */
    public Configuration(Configuration other) {
        this(other.options);
    }

    /**
     * Copy this configuration's options into a property list.
     * @param properties the property list into which to copy the options.
     */
    public void copyTo(Properties properties) {
        for(String name : optionNames()) {
            properties.setProperty(name, option(name));
        }
    }

    /**
     * Copy this configuration's options into a map.
     * @param map the map into which to copy the options.
     */
    public void copyTo(Map<String,String> map) {
        map.putAll(options);
    }

    /**
     * Indicate whether this configuration defines a value for the specified option.
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
     * Return the value of an option.
     * @param name the name of an option.
     * @return the value of the option, or {@code null} if this configuration has no value for the option.
     */
    public String option(String name) {
        return options.get(name);
    }

    /**
     * Return the names of this configuration's options.
     * @return an unmodifiable set of the names of this configuration's options.
     */
    public Set<String> optionNames() {
        return Collections.unmodifiableSet(options.keySet());
    }
    /**
     * Return the value of a required option.
     * @param name the name of an option.
     * @return the value of the option.
     * @throws RequiredOptionException if this configuration has no value for the option.
     */
    public String requiredOption(String name) {
        if(defines(name)) return option(name);
        throw new RequiredOptionException(name);
    }

    /**
     * Define an option by supplying a value.
     * If the configuration already has a value for the option,
     * the old value is replaced by the specified value.
     *
     * @param name  the name of the option.
     * @param value the value for the option.
     */
    public void set(String name, String value) {
        options.put(name, value);
    }
}
