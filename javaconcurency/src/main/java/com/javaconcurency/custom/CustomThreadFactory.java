/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javaconcurency.custom;

import java.util.concurrent.ThreadFactory;

/**
 *
 * @author nhthach
 */
public class CustomThreadFactory implements ThreadFactory {
    
    private static int counter = 0;

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("Custom  Thread - " + (++counter));
        return thread;
    }
    
}
