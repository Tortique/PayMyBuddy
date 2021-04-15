package com.paymybuddy.p6.DAO;

import com.paymybuddy.p6.Database.Constants;
import com.paymybuddy.p6.Database.DatabaseConfig;
import com.paymybuddy.p6.Model.Account;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AccountDAO implements IAccountDAO {

    public DatabaseConfig databaseConfig;

    public AccountDAO(DatabaseConfig config) {
        databaseConfig = config;
    }

    public Result saveAccount(Account account) {
        Connection connection = null;
        try {
            connection = databaseConfig.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(Constants.SaveAccount);
            preparedStatement.setInt(1, account.getAccountId());
            preparedStatement.setInt(2, account.getBalance());
            preparedStatement.execute();
            databaseConfig.closePreparedStatement(preparedStatement);
            return Result.success;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Result.failure;
    }

    public Integer getAccountBalance(int accountId) {
        Connection connection = null;
        int account = 0;
        try {
            connection = databaseConfig.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(Constants.GetAccountBalance);
            preparedStatement.setInt(1, accountId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                account = resultSet.getInt(1);
            }
            databaseConfig.closeResultSet(resultSet);
            databaseConfig.closePreparedStatement(preparedStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return account;
    }

    public boolean getExistingAccount(int accountId) {
        Connection connection = null;
        try {
            connection = databaseConfig.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(Constants.GetAccount);
            preparedStatement.setInt(1, accountId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            databaseConfig.closeResultSet(resultSet);
            databaseConfig.closePreparedStatement(preparedStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public Result updateBalance(Account account) {
        Connection connection = null;
        try {
            connection = databaseConfig.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(Constants.UpdateAccount);
            preparedStatement.setInt(1, account.getBalance());
            preparedStatement.setInt(2, account.getAccountId());
            preparedStatement.execute();
            databaseConfig.closePreparedStatement(preparedStatement);
            return Result.success;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Result.failure;
    }
}
