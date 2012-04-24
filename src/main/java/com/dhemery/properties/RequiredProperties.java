package com.dhemery.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The {@code RequiredProperties} class represents a set of required properties
 * loaded from a list of required property files. Throws an exception if a
 * required file does not exist or if a required property is not defined.
 * 
 * @author Dale Emery
 */
public class RequiredProperties {
	private Properties properties = new Properties();

	/**
	 * Loads properties from property files, in the order that the file names
	 * are listed. If multiple files define a property, the value loaded last is
	 * retained.
	 * 
	 * @param propertyFileNames
	 *            the names of property files to load.
	 * @throws RequiredPropertyFileException
	 *             if a property file does not exist.
	 * @throws RequiredPropertyIOException
	 *             if an IO exception occurs while loading properties.
	 */
	public RequiredProperties(String... propertyFileNames) {
		for (String filename : propertyFileNames) {
			loadProperties(filename);
		}
	}

	/**
	 * @param propertyName
	 *            the name of a property.
	 * @return the value of the property.
	 * @throws RequiredPropertyException
	 *             if no such property is defined.
	 */
	public String get(String propertyName) {
		if (properties.containsKey(propertyName))
			return properties.getProperty(propertyName);
		throw new RequiredPropertyException(propertyName);
	}

    /**
     * @param propertyName
     *            the name of a property.
     * @return the Boolean value of the property.
     * @throws RequiredPropertyException
     *             if no such property is defined.
     * @throws NumberFormatException
     *             if the property's value cannot be parsed as an integer.
     */
	public Boolean getBoolean(String propertyName) {
		return Boolean.parseBoolean(get(propertyName));
	}

	/**
	 * @param propertyName
	 *            the name of a property.
	 * @return the Integer value of the property.
	 * @throws RequiredPropertyException
	 *             if no such property is defined.
	 * @throws NumberFormatException
	 *             if the property's value cannot be parsed as an integer.
	 */
	public Integer getInteger(String propertyName) {
		return Integer.parseInt(get(propertyName));
	}

	private void loadProperties(String filename) {
		InputStream propertiesFile;
		try {
			propertiesFile = new FileInputStream(filename);
			properties.load(propertiesFile);
			propertiesFile.close();
		} catch (FileNotFoundException e) {
			throw new RequiredPropertyFileException(filename);
		} catch (IOException e) {
			throw new RequiredPropertyIOException(filename, e);
		}
	}

    /**
     * @return the properties loaded from the properties files.
     */
    public Properties properties() {
        return properties;
    }
}
