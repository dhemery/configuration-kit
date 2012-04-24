package com.dhemery.properties;

import java.io.IOException;

/**
 * An IO exception during attempt to read a properties file.
 */
public class RequiredPropertyIOException extends RuntimeException {
	public RequiredPropertyIOException(String filename,
			IOException originalException) {
		super(String.format(
				"IO Exception while trying to load properties from %s",
				filename), originalException);
	}

}
