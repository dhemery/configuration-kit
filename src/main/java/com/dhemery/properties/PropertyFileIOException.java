package com.dhemery.properties;

import java.io.IOException;

/**
 * An IO exception while reading properties from a file.
 */
public class PropertyFileIOException extends RuntimeException {
    public PropertyFileIOException(String filename, IOException cause) {
        super(explain(filename), cause);
    }

    private static String explain(String filename) {
        return String.format("IO Exception while reading properties from %s", filename);
    }
}
