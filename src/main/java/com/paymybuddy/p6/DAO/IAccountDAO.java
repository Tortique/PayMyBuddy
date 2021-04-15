package com.paymybuddy.p6.DAO;

import com.paymybuddy.p6.Model.Account;

public interface IAccountDAO {
    Result saveAccount(Account account);

    Integer getAccountBalance(int accountId);

    boolean getExistingAccount(int accountId);

    Result updateBalance(Account account);
}
