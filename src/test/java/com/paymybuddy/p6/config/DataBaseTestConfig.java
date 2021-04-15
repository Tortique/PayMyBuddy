package com.paymybuddy.p6.config;

import com.paymybuddy.p6.Database.DatabaseConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DataBaseTestConfig extends DatabaseConfig {
    private final Logger logger = LogManager.getLogger("DataBaseTestConfig");
    private Connection connection;

    public Connection connect() {
        if (connection == null) {
            try {
                Properties properties = new Properties();
                FileInputStream inputStream = new FileInputStream("src/test/java/com/paymybuddy/p6/config/databaseTest.properties");
                properties.load(inputStream);
                inputStream.close();
                String databaseDriver =properties.getProperty("jdbc.driver");
                Class.forName(databaseDriver);
                String databaseUrl = properties.getProperty("jdbc.url");
                String username = properties.getProperty("jdbc.username");
                String password = properties.getProperty("jdbc.password");
                connection = DriverManager.getConnection(databaseUrl, username, password );
            } catch (ClassNotFoundException | SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        return connection;
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
