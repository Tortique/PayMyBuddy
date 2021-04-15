package com.paymybuddy.p6.DAO;

import com.paymybuddy.p6.Model.User;
import com.paymybuddy.p6.config.DataBasePreparing;
import com.paymybuddy.p6.config.DataBaseTestConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
public class UserDAOTests {
    private final DataBaseTestConfig databaseTestConfig = new DataBaseTestConfig();
    private DataBasePreparing dataBasePreparing;
    private UserDAO userDAO;

    @Before
    public void setUp() {
        userDAO = new UserDAO(databaseTestConfig);
        userDAO.databaseConfig = databaseTestConfig;
        dataBasePreparing = new DataBasePreparing();
    }

    @After
    public void tearDown() {
        dataBasePreparing.clearDataBaseEntries();
    }

    @Test
    public void saveUserTest() {
        User user = new User(1, "Jean@gmail.com", "pass", "Jean", 1);
        Result sut = userDAO.saveUser(user);
        assertEquals(Result.success, sut);
    }

    @Test
    public void getUserTest() {
        User user = new User(1, "Jean@gmail.com", "pass", "Jean", 1);
        userDAO.saveUser(user);
        User userFound = userDAO.getUser("Jean@gmail.com");
        User sut = new User(1, "Jean@gmail.com", null, "Jean", 0);
        assertEquals(sut, userFound);
    }

    @Test
    public void getUserByIdTest() {
        User user = new User(1, "Jean@gmail.com", "pass", "Jean", 1);
        userDAO.saveUser(user);
        User userFound = userDAO.getUserById(1);
        User sut = new User(0, "Jean@gmail.com", null, "Jean", 0);
        assertEquals(sut, userFound);
    }
}
