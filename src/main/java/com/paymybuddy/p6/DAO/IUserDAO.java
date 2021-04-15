package com.paymybuddy.p6.DAO;

import com.paymybuddy.p6.Model.User;

public interface IUserDAO {
    Result saveUser(User user);

    User getUser(String email);

    User getUserById(int userId);
}
