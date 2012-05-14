package com.dhemery.configuration;

/**
 * An attempt to get the value of a option that does not have a value.
 */
public class RequiredOptionException extends RuntimeException {

    public RequiredOptionException(String missingOptionName) {
        super(explain(missingOptionName));
    }

    private static String explain(String missingOpotionName) {
        return String.format("No value for required option: %s", missingOpotionName);
    }
}
