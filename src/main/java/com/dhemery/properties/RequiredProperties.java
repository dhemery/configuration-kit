package com.dhemery.properties;

import java.util.HashMap;
import java.util.Map;

/**
 * A set of properties for which values must be defined.
 * Attempting to get an undefined property
 * causes a {@link RequiredPropertyException}.
 *
 * @author Dale Emery
 */
public class RequiredProperties {
    Map<String,String> properties;
    /**
     * @param properties the properties.
     */
    public RequiredProperties(Map<String,String> properties) {
        this.properties = new HashMap<String,String>(properties);
    }

    /**
     * @param propertyName the name of a property.
     * @return the value of the property.
     * @throws RequiredPropertyException if no such property is defined.
     */
    public String get(String propertyName) {
        if (properties.containsKey(propertyName))
            return properties.get(propertyName);
        throw new RequiredPropertyException(propertyName);
    }
}
