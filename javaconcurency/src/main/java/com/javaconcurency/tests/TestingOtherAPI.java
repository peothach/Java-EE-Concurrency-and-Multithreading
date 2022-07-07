/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javaconcurency.tests;

import com.javaconcurency.runnables.LoggingProcessor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhthach
 */
public class TestingOtherAPI {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Callable<Boolean>> callables = new ArrayList<>();
        try {
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());

            List<Future<Boolean>> futures = executorService.invokeAll(callables);

            for (Future<Boolean> future : futures) {
                System.out.println("Operation result:" + future.get());
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TestingOtherAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(TestingOtherAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            System.out.println(executorService.invokeAny(callables));
        } catch (InterruptedException ex) {
            Logger.getLogger(TestingOtherAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(TestingOtherAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        executorService.shutdown();
        try {
            System.out.println("service shut down? " + executorService.awaitTermination(30, TimeUnit.SECONDS));
        } catch (InterruptedException ex) {
            executorService.shutdownNow();
            Logger.getLogger(TestingOtherAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
