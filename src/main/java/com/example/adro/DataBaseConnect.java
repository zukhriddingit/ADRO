package com.example.adro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseConnect {
    private static final Logger LOGGER = Logger.getLogger(DataBaseConnect.class.getName());
    private static final String DEFAULT_HOST = "127.0.0.1";
    private static final String DEFAULT_PORT = "3306";
    private static final String DEFAULT_DB_NAME = "adro";
    private static final String DEFAULT_USERNAME = "root";
    private static final String DEFAULT_PASSWORD = "";

    public static Connection getConnect() {
        String host = getEnv("ADRO_DB_HOST", DEFAULT_HOST);
        String port = getEnv("ADRO_DB_PORT", DEFAULT_PORT);
        String dbName = getEnv("ADRO_DB_NAME", DEFAULT_DB_NAME);
        String username = getEnv("ADRO_DB_USERNAME", DEFAULT_USERNAME);
        String password = getEnv("ADRO_DB_PASSWORD", DEFAULT_PASSWORD);
        String url = String.format("jdbc:mysql://%s:%s/%s", host, port, dbName);

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Failed to connect to database", ex);
            throw new IllegalStateException("Unable to connect to database", ex);
        }
    }

    private static String getEnv(String name, String fallback) {
        String value = System.getenv(name);
        if (value == null || value.isBlank()) {
            return fallback;
        }
        return value;
    }
}
