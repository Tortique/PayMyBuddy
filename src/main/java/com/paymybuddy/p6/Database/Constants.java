package com.paymybuddy.p6.Database;

public class Constants {
    public static final String SaveUser = "insert into users(email, password, name, enabled) values(?,?,?,?)";
    public static final String GetUser = "select userId, email, name from users where email=?";

    public static final String SaveFriend = "insert into friends(userId, friendId) values (?,?)";
    public static final String GetFriends = "select distinct email,name from users u inner join friends f on f.friendId = u.userId where f.userId=? " +
            "union " +
            "select distinct email,name from users u inner join friends f on f.userId = u.userId where f.friendId=?";
}