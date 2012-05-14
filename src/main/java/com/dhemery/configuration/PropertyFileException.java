package com.dhemery.configuration;

import java.io.IOException;

/**
 * An attempt to read a property file that does not exist.
 */
public class PropertyFileException extends RuntimeException {

    public PropertyFileException(String filename, IOException cause) {
        super(explain(filename), cause);
    }

    private static String explain(String filename) {
        return String.format("Can not find property file %s", filename);
    }
}
