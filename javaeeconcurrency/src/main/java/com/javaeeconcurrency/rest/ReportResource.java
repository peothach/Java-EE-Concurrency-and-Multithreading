package com.javaeeconcurrency.rest;

import com.javaeeconcurrency.beans.BankAccount;
import com.javaeeconcurrency.dao.BankAccountDao;
import com.javaeeconcurrency.runnables.ReportsProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/api/v1")
public class ReportResource {
    private final BankAccountDao bankAccountDao = new BankAccountDao();
    private final ExecutorService executorService = Executors.newFixedThreadPool(3);


    @GetMapping("/report")
    public String generateReports() throws SQLException {
        System.out.println("Services Object From JNDI look up: " +executorService);
        List<BankAccount> accounts = bankAccountDao.getAllBankAccount();

        for (BankAccount account: accounts) {
            Future<Boolean> future = executorService.submit(new ReportsProcessor(account, bankAccountDao));
            try {
                System.out.println("Report generated? " + future.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        return "Report generation task submitted!";
    }

}
