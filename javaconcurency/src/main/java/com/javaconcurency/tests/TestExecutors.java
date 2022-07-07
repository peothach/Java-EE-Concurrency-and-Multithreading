/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javaconcurency.tests;

import com.javaconcurency.dao.UserDao;
import com.javaconcurency.runnables.UserProcessor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhthach
 */
public class TestExecutors {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<String> users = getUserFromFile("C:\\Users\\nhthach\\Desktop\\Personal-Git\\Java-EE-Concurrency-and-Multithreading\\Ex_Files_Java_EE_Concurrency\\Exercise Files\\Chapter3\\03_04\\begin\\new_users.txt");
        UserDao dao = new UserDao();

        for (String user : users) {
            executorService.submit(new UserProcessor(user, dao));
        }
        executorService.shutdown();

        System.out.println("Main execution over!");
    }

    public static List<String> getUserFromFile(String fileName) {
        List<String> users = new ArrayList<>();

        try ( BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                users.add(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestExecutors.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;

    }

}
