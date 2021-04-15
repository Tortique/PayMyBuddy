package com.paymybuddy.p6.DAO;

import com.paymybuddy.p6.Model.Account;
import com.paymybuddy.p6.Model.Transaction;
import com.paymybuddy.p6.Model.TransactionHistory;

import java.util.ArrayList;

public interface ITransactionDAO {
    Result saveTransaction(Transaction transaction);

    Result payFriend(Transaction transaction, Account userAccount, Account friendAccount);

    ArrayList<TransactionHistory> getTransactionsList(int userId);
}
