package com.dhemery.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * Load properties from one or more property files
 * and deliver the properties in a variety of representations.
 */
public class LoadProperties {
    private final Properties properties;

    /**
     * Load properties from property files in the order that the file names
     * are listed. If multiple files define a property, the value loaded last is
     * retained.
     *
     * @param propertyFileNames the names of the files from which to read properties.
     * @throws PropertyFileException   if a property file does not exist.
     * @throws PropertyFileIOException if an IO exception occurs while loading properties.
     */
    public static LoadProperties fromFiles(String... propertyFileNames) {
        return new LoadProperties(propertyFileNames);
    }

    private LoadProperties(String... propertyFileNames) {
        properties = new Properties();
        for (String filename : propertyFileNames) {
            loadPropertiesFromFile(filename);
        }
    }

    /**
     * Copy the loaded properties into a configuration.
     * @param configuration the configuration into which to copy the properties.
     */
    public void into(Configuration configuration) {
        for (String name : properties.stringPropertyNames()) {
            configuration.set(name, properties.getProperty(name));
        }
    }

    /**
     * Copy the loaded properties into a map.
     * @param map the map into which to copy the properties.
     */
    public void into(Map<String, String> map) {
        for (String name : properties.stringPropertyNames()) {
            map.put(name, properties.getProperty(name));
        }
    }

    /**
     * Copy the loaded properties into a properties list.
     * @param properties the properties list into which to copy the properties.
     */
    public void into(Properties properties) {
        for (String name : this.properties.stringPropertyNames()) {
            properties.setProperty(name, this.properties.getProperty(name));
        }
    }

    private void loadPropertiesFromFile(String filename) {
        try {
            InputStream propertiesFile = new FileInputStream(filename);
            properties.load(propertiesFile);
            propertiesFile.close();
        } catch (FileNotFoundException cause) {
            throw new PropertyFileException(filename, cause);
        } catch (IOException cause) {
            throw new PropertyFileIOException(filename, cause);
        }
    }
}
