/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.custom;

import java.util.concurrent.ThreadFactory;

/**
 *
 * @author Ketkee Aryamane
 */
public class CustomThreadFactory implements ThreadFactory{
    
    private static int counter=0;

    @Override
    public Thread newThread(Runnable r) {
        
        Thread thread = new Thread(r);
        thread.setName("Custom Thread - "+(++counter));
        return thread;
    }
    
}
