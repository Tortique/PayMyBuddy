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
    public DatabaseConfig databaseConfig;

    public UserDAO(DatabaseConfig config) {
        databaseConfig = config;
    }

    public void saveUser(User user) {
        Connection connection = null;
        try {
            connection = databaseConfig.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(Constants.SaveUser);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setInt(4, 1);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUser(String email) {
        Connection connection = null;
        User user = null;
        try {
            connection = databaseConfig.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(Constants.GetUserByEmail);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setEmail(email);
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(3));
            }
            databaseConfig.closeResultSet(resultSet);
            databaseConfig.closePreparedStatement(preparedStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public User getUserById(int userId) {
        Connection connection = null;
        User user = null;
        try {
            connection = databaseConfig.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(Constants.GetUserById);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setEmail(resultSet.getString(1));
                user.setName(resultSet.getString(2));
            }
            databaseConfig.closeResultSet(resultSet);
            databaseConfig.closePreparedStatement(preparedStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
