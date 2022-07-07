/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.rest;

import com.app.dao.BankAccountDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.ws.rs.Path;

/**
 *
 * @author Ketkee Aryamane
 */
@Path("reports")
public class ReportsResource {
    
    private BankAccountDao dao;
    
     @Resource(lookup = "java:comp/DefaultManagedExecutorService")
     private ManagedExecutorService service;

    public ReportsResource() {
        
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setUser("root");
            dataSource.setPassword("root");
            dao = new BankAccountDao(dataSource);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(ReportsResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
     


}
