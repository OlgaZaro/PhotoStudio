package com.solvd.photostudio.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertiesUtil {
    private static String host;
    private static String name;
    private static String password;
    private static final String path = "src/main/resources/connection.properties";


    public PropertiesUtil(String host, String name, String password) {
        PropertiesUtil.host = host;
        PropertiesUtil.name = name;
        PropertiesUtil.password = password;
    }

    public static void loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(path));
            host = properties.getProperty("db.host");
            name = properties.getProperty("db.name");
            password = properties.getProperty("db.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
