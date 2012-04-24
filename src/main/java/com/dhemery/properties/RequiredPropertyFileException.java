package com.dhemery.properties;

/**
 * An attempt to read a properties file that does not exist.
 */
public class RequiredPropertyFileException extends RuntimeException {

	public RequiredPropertyFileException(String filename) {
		super(String.format("Please create a properties file named %s",
				filename));
	}
}
