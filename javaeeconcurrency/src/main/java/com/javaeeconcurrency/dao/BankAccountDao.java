package com.javaeeconcurrency.dao;

import com.javaeeconcurrency.beans.BankAccount;
import com.javaeeconcurrency.beans.BankAccountTransaction;
import com.javaeeconcurrency.utils.DBConnection;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankAccountDao {

    public List<BankAccount> getAllBankAccount() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        List<BankAccount> accounts = new ArrayList<>();

        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bank_account");
            while (resultSet.next()) {
                BankAccount account = new BankAccount();
                account.setAccNumber(resultSet.getInt("acc_number"));
                account.setName(resultSet.getString("acc_holder_name"));
                account.setEmail(resultSet.getString("acc_email"));
                account.setAccType(resultSet.getString("acc_type"));
                accounts.add(account);
            }
        } catch (SQLException e) {
            LoggerFactory.getLogger(BankAccountDao.class.getName()).info("Exception", e);
        } finally {
            if (connection != null && statement != null) {
                statement.close();
                connection.close();
            }
        }
        return accounts;
    }

    public List<BankAccountTransaction> getTransactionsForAccount(BankAccount account) {
        BankAccountTransaction transaction = null;
        List<BankAccountTransaction> transactions = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM bank_account_transaction where acc_number=?");
            statement.setInt(1, account.getAccNumber());
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                transaction = new BankAccountTransaction();
                transaction.setAccNumber(set.getInt("acc_number"));
                transaction.setAmount(set.getDouble("amount"));
                transaction.setTxDate(new Date(set.getDate("transaction_date").getTime()));
                transaction.setTxId(set.getInt("tx_id"));
                transaction.setTxType(set.getString("transaction_type"));
                transactions.add(transaction);
            }
        } catch (Exception e) {
            LoggerFactory.getLogger(BankAccountDao.class.getName()).info("Exception", e);
        }

        return transactions;
    }
}
