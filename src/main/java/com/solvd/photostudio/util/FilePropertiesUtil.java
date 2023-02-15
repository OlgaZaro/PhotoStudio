package com.solvd.photostudio.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class FilePropertiesUtil {
    private String path;
    private final String propertiesFile = "src/main/resources/file.properties";

    public FilePropertiesUtil(String value) {
        this.path = getProperties(value);
    }

    public String getPath() {
        return path;
    }

    private String getProperties(String value) {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(propertiesFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        path = prop.getProperty(value);
        return path;
    }
}
