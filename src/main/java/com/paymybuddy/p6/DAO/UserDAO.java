package com.paymybuddy.p6.DAO;

import com.paymybuddy.p6.Database.Constants;
import com.paymybuddy.p6.Database.DatabaseConfig;
import com.paymybuddy.p6.Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public DatabaseConfig databaseConfig;

    public UserDAO(DatabaseConfig config) {
        this.databaseConfig = config;
    }

    public boolean SaveUser(User user) {
        Connection connection = null;
        try {
            connection = databaseConfig.connect();
            try (PreparedStatement preparedStatement = connection.prepareStatement(Constants.SaveUser)) {
                preparedStatement.setInt(1, user.getId());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.setString(4, user.getName());
                return preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        databaseConfig.disconnect(connection);
        return false;
    }

    public User checkLogin(String email, String password) throws SQLException {
        Connection connection = null;
        User user = null;
        try {
            connection = databaseConfig.connect();
            try (PreparedStatement preparedStatement = connection.prepareStatement(Constants.CheckLogin)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt(1));
                    user.setEmail(email);
                    user.setName(resultSet.getString(4));
                }
                databaseConfig.closeResultSet(resultSet);
                databaseConfig.closePreparedStatement(preparedStatement);
            }
        } catch (SQLException e) {

        }
        databaseConfig.disconnect(connection);
        return user;
    }
}
