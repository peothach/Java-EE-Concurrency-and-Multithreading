/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.tests;

import com.app.custom.CustomThreadFactory;
import com.app.runnables.LoggingProcessor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Ketkee Aryamane
 */
public class TestThreadFactory {
    
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3, new CustomThreadFactory());
        
        
        for(int i=0;i<6;i++){
            service.submit(new LoggingProcessor());
        }
        
        
        
    }
    
}
