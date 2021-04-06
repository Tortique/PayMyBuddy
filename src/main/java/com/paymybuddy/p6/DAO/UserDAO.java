package com.paymybuddy.p6.DAO;

import com.paymybuddy.p6.Database.Constants;
import com.paymybuddy.p6.Database.DatabaseConfig;
import com.paymybuddy.p6.Model.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDAO {
    public static DatabaseConfig databaseConfig;

    public UserDAO(DatabaseConfig config) {
        databaseConfig = config;
    }

    public static void saveUser(User user) {
        Connection connection = null;
        try {
            connection = databaseConfig.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(Constants.SaveUser);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setInt(4, 1);
            preparedStatement.execute();
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConfig.disconnect(connection);
        }
    }

    public static User getEmail(String email) {
        Connection connection = null;
        User user = new User();
        try {
            connection = databaseConfig.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(Constants.GetEmail);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return user;
            }
            databaseConfig.closeResultSet(resultSet);
            databaseConfig.closePreparedStatement(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            databaseConfig.disconnect(connection);
        }
        return null;
    }
}
