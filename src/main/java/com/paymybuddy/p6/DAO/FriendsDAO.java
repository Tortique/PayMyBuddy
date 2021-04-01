package com.paymybuddy.p6.DAO;

import com.paymybuddy.p6.Database.Constants;
import com.paymybuddy.p6.Database.DatabaseConfig;
import com.paymybuddy.p6.Model.Friend;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class FriendsDAO {

    public DatabaseConfig databaseConfig;

    public FriendsDAO(DatabaseConfig config) {
        databaseConfig = config;
    }

    public void saveFriend(Friend friend) {
        Connection connection = null;
        try {
            connection = databaseConfig.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(Constants.SaveFriend);
            preparedStatement.setInt(1, friend.getUserId());
            preparedStatement.setInt(2, friend.getFriendId());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
        }
    }
}
