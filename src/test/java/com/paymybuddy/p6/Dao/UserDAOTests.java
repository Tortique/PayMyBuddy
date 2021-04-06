package com.paymybuddy.p6.Dao;

import com.paymybuddy.p6.DAO.UserDAO;
import com.paymybuddy.p6.Model.User;
import com.paymybuddy.p6.config.DataBasePreparing;
import com.paymybuddy.p6.config.DataBaseTestConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserDAOTests {

    private final DataBaseTestConfig dataBaseTestConfig = new DataBaseTestConfig();
    private DataBasePreparing dataBasePreparing;
    private UserDAO userDAO;

    @BeforeAll
    public void setUp() {
        userDAO = new UserDAO(dataBaseTestConfig);
        dataBasePreparing = new DataBasePreparing();
    }

    @Test
    public void saveUserTest() {
        User user = new User();
        user.setEmail("haha@gmail.com");
        user.setPassword("plop");
        user.setName("Bob");
        userDAO.saveUser(user);
    }
}
