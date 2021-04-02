package com.paymybuddy.p6.Model;

import lombok.Data;

@Data
public class Friend {
    private int userId;
    private int friendId;

    public Friend() {
    }

    public Friend(int userId, int friendId) {
        this.userId = userId;
        this.friendId = friendId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }
}
