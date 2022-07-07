/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javaconcurency.tests;

import com.javaconcurency.runnables.CleaningScheduler;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author nhthach
 */
public class TestSchedulors {
    
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        //scheduledExecutorService.schedule(new CleaningScheduler(), 5, TimeUnit.SECONDS);
        //scheduledExecutorService.scheduleAtFixedRate(new CleaningScheduler(), 5, 4, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(new CleaningScheduler(), 5, 4, TimeUnit.SECONDS);
        // first task after an initial delay of 5s
        // 2s for the task to execute
        // waiting time of 4s
    }
}
