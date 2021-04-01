package com.paymybuddy.p6.Database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;

import java.sql.*;
import java.util.Properties;

@Configuration
public class DatabaseConfig {
    private final Logger logger = LogManager.getLogger("DataBaseConfig");
    private Connection connection;
    private Properties properties;

    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            String username = "root";
            properties.setProperty("user", username);
            String password = "rootroot";
            properties.setProperty("password", password);
        }
        return properties;
    }

    public Connection connect() {
        if (connection == null) {
            try {
                String databaseDriver = "com.mysql.cj.jdbc.Driver";
                Class.forName(databaseDriver);
                String databaseUrl = "jdbc:mysql://localhost:3306/prod?serverTimezone=Europe/Paris";
                connection = DriverManager.getConnection(databaseUrl, getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void disconnect(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                logger.info("Closing connection");
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
