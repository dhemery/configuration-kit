package com.dhemery.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Read properties from one or more property files
 * and deliver the properties as a {@link Map}.
 */
public class ReadProperties {
    private final Properties properties;

    /**
     * Read properties from property files in the order that the file names
     * are listed. If multiple files define a property, the value loaded last is
     * retained.
     *
     * @param propertyFileNames the names of the files from which to read properties.
     * @throws PropertyFileException   if a property file does not exist.
     * @throws PropertyFileIOException if an IO exception occurs while loading properties.
     */
    public static ReadProperties fromFiles(String... propertyFileNames) {
        return new ReadProperties(propertyFileNames);
    }

    private ReadProperties(String... propertyFileNames) {
        properties = new Properties();
        for (String filename : propertyFileNames) {
            loadPropertiesFromFile(filename);
        }
    }

    /**
     * @return a map of the properties.
     */
    public Map<String, String> asMap() {
        Map<String, String> map = new HashMap<String, String>();
        for (String name : properties.stringPropertyNames()) {
            map.put(name, properties.getProperty(name));
        }
        return map;
    }

    private void loadPropertiesFromFile(String filename) {
        InputStream propertiesFile;
        try {
            propertiesFile = new FileInputStream(filename);
            properties.load(propertiesFile);
            propertiesFile.close();
        } catch (FileNotFoundException cause) {
            throw new PropertyFileException(filename, cause);
        } catch (IOException cause) {
            throw new PropertyFileIOException(filename, cause);
        }
    }
}
