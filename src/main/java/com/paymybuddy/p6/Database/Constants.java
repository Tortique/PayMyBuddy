package com.paymybuddy.p6.Database;

public class Constants {
    public static final String SaveUser = "insert into user(email, password, name, enabled) values(?,?,?,?)";
    public static final String GetUserByEmail = "select userId, email, name from user where email=?";
    public static final String GetUserById = "select email, name from user where userId=?";

    public static final String SaveFriend = "insert into friend(userId, friendId) values (?,?)";
    public static final String GetFriends = "select distinct u.userId,email,name from user u inner join friend f on f.friendId = u.userId where f.userId=? " +
            "union " +
            "select distinct u.userId,email,name from user u inner join friend f on f.userId = u.userId where f.friendId=?";

    public static final String SaveAccount = "insert into account(accountId,balance) values (?,?)";
    public static final String GetAccount = "select * from account where accountId=?";
    public static final String GetAccountBalance = "select balance from account where accountId=?";
    public static final String UpdateAccount = "update account set balance=? where accountId=?";

    public static final String SaveTransaction = "insert into transaction(transactionUserId,transactionFriendId,value,comment) values(?,?,?,?)";
    public static final String GetTransactions = "select transactionFriendId,value,comment from transaction where transactionUserId=? order by transactionId desc limit 10";
}
