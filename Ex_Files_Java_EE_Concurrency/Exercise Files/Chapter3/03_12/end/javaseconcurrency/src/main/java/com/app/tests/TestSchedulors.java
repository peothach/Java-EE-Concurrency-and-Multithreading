/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.tests;

import com.app.runnables.CleaningScheduler;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Ketkee Aryamane
 */
public class TestSchedulors {
    
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.schedule(new CleaningScheduler(), 5, TimeUnit.SECONDS);
    }
    
}
