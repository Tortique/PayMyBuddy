package com.paymybuddy.p6.DAO;

import com.paymybuddy.p6.Model.Friend;
import com.paymybuddy.p6.Model.User;

import java.util.ArrayList;

public interface IFriendsDAO {
    void saveFriend(Friend friend);

    ArrayList<User> getFriendsList(int userId);
}
