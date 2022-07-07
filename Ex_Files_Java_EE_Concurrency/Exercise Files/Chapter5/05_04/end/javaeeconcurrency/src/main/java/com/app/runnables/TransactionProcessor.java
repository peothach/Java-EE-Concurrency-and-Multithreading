/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.runnables;

import com.app.ejbbeans.TransactionBean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author Ketkee Aryamane
 */
public class TransactionProcessor implements Runnable{
    
    private UserTransaction userTransaction;
    private TransactionBean bean;

    public TransactionProcessor() {
        
        try {
            InitialContext context = new InitialContext();
            userTransaction = (UserTransaction) context.lookup("java:comp/UserTransaction");
            bean = (TransactionBean)context.lookup("java:module/tx-bean");
        } catch (NamingException ex) {
            Logger.getLogger(TransactionProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        
        try {
            userTransaction.begin();
            bean.saveBankAccountTransaction();
            bean.saveBankAccountTransactionLog();
            userTransaction.commit();
        }catch(Exception exception){
            System.out.println("ROLLING BACK because: "+exception.getMessage());
            try {
                userTransaction.rollback();
            } catch (IllegalStateException ex) {
                Logger.getLogger(TransactionProcessor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(TransactionProcessor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(TransactionProcessor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    
    
    
}
