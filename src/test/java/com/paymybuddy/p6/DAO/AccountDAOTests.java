package com.paymybuddy.p6.DAO;

import com.paymybuddy.p6.Model.Account;
import com.paymybuddy.p6.config.DataBasePreparing;
import com.paymybuddy.p6.config.DataBaseTestConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
public class AccountDAOTests {
    private final DataBaseTestConfig dataBaseTestConfig = new DataBaseTestConfig();
    private DataBasePreparing dataBasePreparing;
    private AccountDAO accountDAO;

    @Before
    public void setUp() {
        accountDAO = new AccountDAO(dataBaseTestConfig);
        accountDAO.databaseConfig = dataBaseTestConfig;
        dataBasePreparing = new DataBasePreparing();
    }

    @After
    public void tearDown() {
        dataBasePreparing.clearDataBaseEntries();
    }

    @Test
    public void saveAccountTest() {
        Account account = new Account(1, 100);
        Result sut = accountDAO.saveAccount(account);
        assertEquals(Result.success, sut);
    }

    @Test
    public void getAccountBalanceTest() {
        Account account = new Account(1, 100);
        accountDAO.saveAccount(account);
        int balance = accountDAO.getAccountBalance(1);
        int sut = 100;
        assertEquals(sut, balance);
    }

    @Test
    public void getExistingAccountTest() {
        Account account = new Account(1, 100);
        accountDAO.saveAccount(account);
        boolean isExist = accountDAO.getExistingAccount(1);
        assertThat(isExist).isTrue();
    }

    @Test
    public void updateBalanceTest() {
        Account account = new Account(1, 100);
        accountDAO.saveAccount(account);
        account.setBalance(200);
        Result sut = accountDAO.updateBalance(account);
        int expectedBalance = 200;
        assertEquals(expectedBalance, accountDAO.getAccountBalance(1));
        assertEquals(Result.success, sut);
    }
}
