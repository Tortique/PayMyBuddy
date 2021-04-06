package com.paymybuddy.p6.Database;

public class Constants {
    public static final String SaveUser = "insert into users(email, password, name, enabled) values(?,?,?,?)";
    public static final String GetUser = "select userId, email, name from users where email=?";

    public static final String SaveFriend = "insert into friends(userId, friendId) values (?,?)";
    public static final String GetFriends = "select distinct email,name from users u inner join friends f on f.friendId = u.userId where f.userId=? " +
            "union " +
            "select distinct email,name from users u inner join friends f on f.userId = u.userId where f.friendId=?";

    public static final String SaveAccount = "insert into account(accountId,balance) values (?,?)";
    public static final String GetAccount = "select * from account where accountId=?";
    public static final String GetAccountBalance = "select balance from account where accountId=?";
    public static final String UpdateAccount = "update account set balance=? where accountId=?";
}
