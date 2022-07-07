/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javaconcurency.tests;

import com.javaconcurency.custom.CustomThreadFactory;
import com.javaconcurency.runnables.LoggingProcessor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author nhthach
 */
public class TestThreadFactory {
    
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3, new CustomThreadFactory());
        
        for (int i = 0; i<6; i++) {
            executorService.submit(new LoggingProcessor());
        }
    }
    
}
