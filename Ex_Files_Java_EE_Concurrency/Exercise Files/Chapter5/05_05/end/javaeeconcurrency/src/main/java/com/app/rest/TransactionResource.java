/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.rest;

import com.app.runnables.TransactionProcessor;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author Ketkee Aryamane
 */
@Path("transactions")
public class TransactionResource {
    
    @Resource(lookup = "java:comp/DefaultManagedExecutorService")
    private ManagedExecutorService service;
    
    @POST
    public String executeTransactions(){
        service.submit(new TransactionProcessor());
        return "Transactions submitted, please check console";
        
    }
    
}
