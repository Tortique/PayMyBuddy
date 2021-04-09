package com.paymybuddy.p6.Model;

import lombok.Data;

@Data
public class Transaction {
    private int transactionUserId;
    private int transactionFriendId;
    private int value;
    private String comment;

    public Transaction() {
    }

    public Transaction(int transactionUserId, int transactionFriendId, int value, String comment) {
        this.transactionUserId = transactionUserId;
        this.transactionFriendId = transactionFriendId;
        this.value = value;
        this.comment = comment;
    }

    public int getTransactionFriendId() {
        return transactionFriendId;
    }

    public void setTransactionFriendId(int transactionFriendId) {
        this.transactionFriendId = transactionFriendId;
    }

    public int getTransactionUserId() {
        return transactionUserId;
    }

    public void setTransactionUserId(int transactionUserId) {
        this.transactionUserId = transactionUserId;
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
