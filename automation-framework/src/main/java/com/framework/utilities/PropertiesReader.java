package com.framework.utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    public static Properties loadProperties(String filePath) {
        Properties properties = new Properties();
        
        try (FileInputStream fileInput = new FileInputStream(filePath)) {
            properties.load(fileInput);
        } catch (IOException e) {
            System.out.println("Error reading properties file: " + e.getMessage());
        }

        return properties;
    }

    
}
