package helpers;

import java.io.IOException;

/**
 * ReadProperties class provides methods for read properties from file.
 */
public class ReadProperties {

    /**
     * ReadProperties() method read properties from file and if it is impossible throws an exception.
     */
    public static void readProperties() {
        try {
            System.getProperties().load(ClassLoader.getSystemResourceAsStream("test.properties"));
        } catch (IOException e) {
            throw new RuntimeException("The properties file cannot be read", e);
        }
    }

    /**
     * ReadProperty() method read the property by the property key and returns property value.
     */
    public static String readProperty(String propertyKey) {
        return System.getProperty(propertyKey);
    }
}
