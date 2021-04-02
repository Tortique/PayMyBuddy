package com.paymybuddy.p6.DAO;

import com.paymybuddy.p6.Database.Constants;
import com.paymybuddy.p6.Database.DatabaseConfig;
import com.paymybuddy.p6.Model.Friend;
<<<<<<< HEAD
import com.paymybuddy.p6.Model.User;
=======
>>>>>>> origin/Friends
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
<<<<<<< HEAD
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
=======
import java.sql.SQLException;
>>>>>>> origin/Friends

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
<<<<<<< HEAD
            databaseConfig.closePreparedStatement(preparedStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<User> getFriendsList(int userId) {
        Connection connection = null;
        User user;
        ArrayList<User> friendsList = new ArrayList<>();
        try {
            connection = databaseConfig.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(Constants.GetFriends);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2,userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setEmail(resultSet.getString(1));
                user.setName(resultSet.getString(2));
                friendsList.add(user);
            }
            databaseConfig.closeResultSet(resultSet);
            databaseConfig.closePreparedStatement(preparedStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return friendsList;
    }
=======
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
        }
    }
>>>>>>> origin/Friends
}
