package com.paymybuddy.p6.DAO;

import com.paymybuddy.p6.Model.Transaction;
import com.paymybuddy.p6.config.DataBasePreparing;
import com.paymybuddy.p6.config.DataBaseTestConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(TransactionDAO.class)
public class TransactionDAOTests {
    private final DataBaseTestConfig dataBaseTestConfig = new DataBaseTestConfig();
    private DataBasePreparing dataBasePreparing;
    private TransactionDAO transactionDAO;

    @Before
    public void setUp() {
        transactionDAO = new TransactionDAO(dataBaseTestConfig);
        transactionDAO.databaseConfig = dataBaseTestConfig;
        dataBasePreparing = new DataBasePreparing();
    }

    @After
    public void tearDown() {
        dataBasePreparing.clearDataBaseEntries();
    }

    @Test
    public void saveTransactionTest() {
        Transaction transaction = new Transaction(1, 1, 2, 100, "hello");
        Result sut = transactionDAO.saveTransaction(transaction);
        assertEquals(Result.success, sut);
    }
}
