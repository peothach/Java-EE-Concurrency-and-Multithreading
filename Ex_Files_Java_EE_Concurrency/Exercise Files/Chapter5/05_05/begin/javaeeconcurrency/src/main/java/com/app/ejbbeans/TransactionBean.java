/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ejbbeans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author Ketkee Aryamane
 */
@Stateless(name="tx-bean")
public class TransactionBean {

    
    @Resource(lookup = "jdbc/source1")
    private DataSource source1;
    
    @Resource(lookup = "jdbc/source2")
    private DataSource source2;

    public void saveBankAccountTransaction() throws SQLException{
        
        Connection connection = source1.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into bank_account_transaction values(21,1101,'debit',400,'"+new Date(System.currentTimeMillis())+"')");
    }

    public void saveBankAccountTransactionLog() throws SQLException {
        Connection connection = source2.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into bank_account_transaction_log values(3,21,'system','"+new Date(System.currentTimeMillis())+"')");
    }
    
   
}
