package com.dhemery.properties;

import java.io.IOException;

@SuppressWarnings("serial")
public class RequiredPropertyIOException extends RuntimeException {
	public RequiredPropertyIOException(String filename,
			IOException originalException) {
		super(String.format(
				"IO Exception while trying to load properties from %s",
				filename), originalException);
	}

}
