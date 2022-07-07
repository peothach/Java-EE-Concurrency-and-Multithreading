/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.runnables;

import java.io.File;

/**
 *
 * @author Ketkee Aryamane
 */
public class CleaningScheduler implements Runnable{

    @Override
    public void run() {
        
        File folder = new File("D:/serverlogs");
        File[] files = folder.listFiles();
        for(File file: files){
            if(System.currentTimeMillis()-file.lastModified()>5*60*1000){
                System.out.println("This file will be deleted: "+file.getName());
                file.delete();
            }
        }
        
    }
    
    
    
}
