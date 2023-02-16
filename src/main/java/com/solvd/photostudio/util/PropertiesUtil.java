package com.solvd.photostudio.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertiesUtil {
    private static String host;
    private static String name;
    private static String password;
    private String path;
    private final String propertiesFile = "src/main/resources/file.properties";
    private static final String propertiesFile1 = "src/main/resources/connection.properties";


    public PropertiesUtil(String host, String name, String password) {
        PropertiesUtil.host = host;
        PropertiesUtil.name = name;
        PropertiesUtil.password = password;
    }

    public PropertiesUtil(String value) {
        this.path = getProperties(value);
    }

    public static String getHost() {
        return host;
    }

    public static String getName() {
        return name;
    }

    public static String getPassword() {
        return password;
    }

    public String getPath() { return path; }

    public static void loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(propertiesFile1));
            host = properties.getProperty("db.host");
            name = properties.getProperty("db.name");
            password = properties.getProperty("db.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
