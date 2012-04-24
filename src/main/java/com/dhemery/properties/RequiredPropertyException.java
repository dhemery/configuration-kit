package com.dhemery.properties;

/**
 * An attempt to get the value of a property that does not have a value.
 */
public class RequiredPropertyException extends RuntimeException {

	public RequiredPropertyException(String missingPropertyName) {
		super(String.format("Please define property: %s", missingPropertyName));
	}
}
