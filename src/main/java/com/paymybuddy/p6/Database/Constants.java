package com.paymybuddy.p6.Database;

public class Constants {
    public static final String SaveUser = "insert into users(userId, email, password, name) values(?,?,?,?)";
    public static final String CheckLogin = "select * from users where email=? and password=?";
    public static final String GetUser = "select email from users where email=?";
}
