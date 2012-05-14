package com.dhemery.configuration;

/**
 * An attempt to get the value of a property that does not have a value.
 */
public class RequiredPropertyException extends RuntimeException {

    public RequiredPropertyException(String missingPropertyName) {
        super(explain(missingPropertyName));
    }

    private static String explain(String missingPropertyName) {
        return String.format("No value for required property: %s", missingPropertyName);
    }
}
