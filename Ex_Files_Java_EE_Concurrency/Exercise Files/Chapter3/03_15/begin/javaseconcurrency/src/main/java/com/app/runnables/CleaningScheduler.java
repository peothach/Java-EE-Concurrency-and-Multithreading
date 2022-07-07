/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.runnables;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ketkee Aryamane
 */
public class CleaningScheduler implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CleaningScheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        File folder = new File("D:/serverlogs");
        File[] files = folder.listFiles();
        for(File file: files){
            if(System.currentTimeMillis()-file.lastModified()>5*60*1000){
                System.out.println("This file will be deleted: "+file.getName());
               // file.delete();
            }
        }
        
    }
    
    
    
}
