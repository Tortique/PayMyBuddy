package com.paymybuddy.p6.DAO;

import com.paymybuddy.p6.Database.Constants;
import com.paymybuddy.p6.Database.DatabaseConfig;
import com.paymybuddy.p6.Model.Account;
import com.paymybuddy.p6.Model.Transaction;
import com.paymybuddy.p6.Model.TransactionHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class TransactionDAO implements ITransactionDAO {
    @Autowired
    UserDAO userDAO;

    @Autowired
    AccountDAO accountDAO;

    public DatabaseConfig databaseConfig;

    public TransactionDAO(DatabaseConfig config) {
        databaseConfig = config;
    }

    public Result saveTransaction(Transaction transaction) {
        Connection connection = null;
        try {
            connection = databaseConfig.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(Constants.SaveTransaction);
            preparedStatement.setInt(1, transaction.getTransactionUserId());
            preparedStatement.setInt(2, transaction.getTransactionFriendId());
            preparedStatement.setInt(3, transaction.getValue());
            preparedStatement.setString(4, transaction.getComment());
            preparedStatement.execute();
            databaseConfig.closePreparedStatement(preparedStatement);
            return Result.success;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return Result.failure;
    }

    public Result payFriend(Transaction transaction, Account userAccount, Account friendAccount) {
        Connection connection = null;
        try {
            connection = databaseConfig.connect();
            connection.setAutoCommit(false);
            saveTransaction(transaction);
            if (accountDAO.getExistingAccount(userAccount.getAccountId())) {
                accountDAO.updateBalance(userAccount);
            }
            if (accountDAO.getExistingAccount(friendAccount.getAccountId())) {
                accountDAO.updateBalance(friendAccount);
            }
            connection.commit();
            return Result.success;
        } catch (SQLException throwable) {
            try {
                connection.rollback();
                throwable.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Result.failure;
    }

    public ArrayList<TransactionHistory> getTransactionsList(int userId) {
        Connection connection = null;
        TransactionHistory transaction;
        ArrayList<TransactionHistory> transactions = new ArrayList<>();
        try {
            connection = databaseConfig.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(Constants.GetTransactions);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                transaction = new TransactionHistory();
                transaction.setFriendName(userDAO.getUserById(resultSet.getInt(1)).getName());
                transaction.setValue(resultSet.getInt(2));
                transaction.setComment(resultSet.getString(3));
                transactions.add(transaction);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return transactions;
    }
}
