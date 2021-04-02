package com.paymybuddy.p6.Database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;

import java.sql.*;
import java.util.Properties;

@Configuration
public class DatabaseConfig {
    private static final Logger logger = LogManager.getLogger("DataBaseConfig");
    private static final String databaseDriver = "com.mysql.cj.jdbc.Driver";
    private static final String databaseUrl = "jdbc:mysql://localhost:3306/prod?serverTimezone=Europe/Paris";
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

    public static void disconnect(Connection connection) {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void closePreparedStatement(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
                logger.info("Closing Prepared Statement");
            } catch (SQLException e) {
                logger.error("Error while closing prepared statement", e);
            }
        }
    }

    public void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
                logger.info("Closing Result Set");
            } catch (SQLException e) {
                logger.error("Error while closing result set", e);
            }
        }
    }
}
