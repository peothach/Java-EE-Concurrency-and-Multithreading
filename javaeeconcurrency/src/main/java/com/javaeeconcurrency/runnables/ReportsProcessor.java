package com.javaeeconcurrency.runnables;

import com.javaeeconcurrency.beans.BankAccount;
import com.javaeeconcurrency.beans.BankAccountTransaction;
import com.javaeeconcurrency.dao.BankAccountDao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.concurrent.Callable;

public class ReportsProcessor implements Callable<Boolean> {

    private BankAccount account;
    private BankAccountDao dao;

    public ReportsProcessor(BankAccount account, BankAccountDao dao) {
        this.account = account;
        this.dao = dao;
    }


    @Override
    public Boolean call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " generating report");
        boolean reportGenerated = false;
        List<BankAccountTransaction> transactions = dao.getTransactionsForAccount(account);
        File file = new File("D:\\reports\\" + account.getAccNumber() + "_tx_report.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (BankAccountTransaction transaction : transactions) {
                writer.write("Account Number: " + transaction.getAccNumber());
                writer.write("Transaction type " + transaction.getTxType());
                writer.write("Tx Id: " + transaction.getTxType());
                writer.write("Amount: " + transaction.getAmount());
                writer.write("Transaction Date: " + transaction.getTxDate());
                writer.newLine();
            }
            writer.flush();
        }
        reportGenerated = true;
        return reportGenerated;
    }
}
