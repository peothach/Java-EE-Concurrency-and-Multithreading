/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javaconcurency.runnables;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhthach
 */
public class LoggingProcessor implements Callable<Boolean>{

    @Override
    public Boolean call() throws Exception {
        System.out.println("Thread name " + Thread.currentThread().getName());
        Logger.getLogger(LoggingProcessor.class.getName()).log(Level.INFO, "Logging something!");
        return true;
    }
    
}
