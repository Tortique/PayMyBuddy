package com.paymybuddy.p6.config;

import com.paymybuddy.p6.Database.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseTestConfig extends DatabaseConfig {
    private static final String databaseDriver = "com.mysql.cj.jdbc.Driver";
    private static final String databaseUrl = "jdbc:mysql://localhost:3306/test?serverTimezone=Europe/Paris";
    private static final String username = "root";
    private static final String password = "rootroot";
    private static Connection connection;
    private static Properties properties;

    private static Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", username);
            properties.setProperty("password", password);
        }
        return properties;
    }

    public static Connection connect() {
        if (connection == null) {
            try {
                Class.forName(databaseDriver);
                connection = DriverManager.getConnection(databaseUrl, getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void disconnect() {
        if(connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
