package com.gdb.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class AccountRulesPropertiesLoader {

    private Properties properties = new Properties();

    public AccountRulesPropertiesLoader(String configPath) {
        loadProperties(configPath);
    }

    private void loadProperties(String configPath) {

        InputStream inputStream = null;

        try {
            // First try loading from classpath
            inputStream = getClass()
                    .getClassLoader()
                    .getResourceAsStream(configPath);

            // If not found on classpath, try filesystem
            if (inputStream == null) {
                File file = new File(configPath);

                if (file.exists()) {
                    inputStream = new FileInputStream(file);
                }
            }

            // Load properties if stream was found
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                System.out.println(
                    "[Warning] Properties file not found: " + configPath
                );
            }

        } catch (Exception e) {
            System.out.println(
                "[Warning] Failed to load properties from "
                + configPath + ": " + e.getMessage()
            );

        } finally {

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception ignored) {
                }
            }
        }
    }

    public String getProperty(String key, String defaultValue) {

        String value = properties.getProperty(key);

        if (value == null) {
            return defaultValue;
        }

        return value.trim();
    }

    public double getDouble(String key, double defaultValue) {

        String value = properties.getProperty(key);

        if (value == null) {
            return defaultValue;
        }

        try {
            return Double.parseDouble(value.trim());

        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public int getInt(String key, int defaultValue) {

        String value = properties.getProperty(key);

        if (value == null) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(value.trim());

        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}