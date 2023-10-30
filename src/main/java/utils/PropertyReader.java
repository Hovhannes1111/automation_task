package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PropertyReader {

    private final String PROPERTY_PATH = "src/test/resources/application.properties";
    private final FileInputStream FILE;
    private final Properties PROPERTY;

    static {
        FILE = getFileInputStream();
        PROPERTY = new Properties();
        loadProperty();
    }

    public String readProperty(final String propertyName) {
        return PROPERTY.getProperty(propertyName);
    }

    private FileInputStream getFileInputStream() {
        try {
            return new FileInputStream(PROPERTY_PATH);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    private void loadProperty() {
        try {
            PROPERTY.load(FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
