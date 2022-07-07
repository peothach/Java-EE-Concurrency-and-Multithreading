/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javaconcurency.runnables;

import com.javaconcurency.beans.User;
import com.javaconcurency.dao.UserDao;
import java.util.StringTokenizer;
import java.util.concurrent.Callable;

/**
 *
 * @author nhthach
 */
public class UserProcessor implements Callable<Integer>{
    
    private String userRecord;
    private UserDao dao;

    public UserProcessor(String userRecord, UserDao dao) {
        this.userRecord = userRecord;
        this.dao = dao;
    }
    
    @Override
    public Integer call() throws Exception {
        int rows = 0;
        System.out.println(Thread.currentThread().getName() + " processing record for: " + userRecord);
        StringTokenizer tokenizer = new StringTokenizer(userRecord, ",");
        User user = null;
        
        while (tokenizer.hasMoreTokens()) {
            user = new User();
            user.setEmailAddress(tokenizer.nextToken());
            user.setName(tokenizer.nextToken());
            user.setId(Integer.valueOf(tokenizer.nextToken()));
            rows = dao.saveUser(user);
        }
        
        return rows;
    }
    
    
}
