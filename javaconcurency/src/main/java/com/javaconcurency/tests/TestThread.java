/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javaconcurency.tests;

import com.javaconcurency.runnables.AppThread;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 *
 * @author nhthach
 */
public class TestThread {
    public static void main(String[] args) {
        AppThread thread1 = new AppThread();//NEW
        AppThread thread2 = new AppThread();
        AppThread thread3 = new AppThread();
        
        thread1.start();//RUNNABLE
        thread2.start();
        thread3.start();
        //execute run //RUNNING
        //job completed - TERNINATED/DEAD
        
    }    
}
