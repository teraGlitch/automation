package com.company.android.automation.ontap.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigurationProperties {
    private static InputStream input = ConfigurationProperties.class.getClassLoader().getResourceAsStream("automation.properties");

    private final static Properties prop = new Properties();

    public static String getConfig(String config) {
        String property = "";
        try {

            if (input == null) {
                throw new RuntimeException("File configuration not found!");
            }

            prop.load(input);

            property = prop.getProperty(config);

            if (property == null) {
                throw new RuntimeException("Configuration not found!");
            }

        } catch (IOException ex) {
            ex.getMessage();
        }

        return property;

    }
}
