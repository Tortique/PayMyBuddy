package com.paymybuddy.p6.Model;

import lombok.Data;

@Data
public class TransactionHistory {
    private String friendName;
    private int value;
    private String comment;

    public TransactionHistory() {
    }

    public TransactionHistory(String friendName, int value, String comment) {
        this.friendName = friendName;
        this.value = value;
        this.comment = comment;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
