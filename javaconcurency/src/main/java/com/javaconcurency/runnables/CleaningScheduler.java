/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javaconcurency.runnables;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhthach
 */
public class CleaningScheduler implements Runnable {

    private final int ONE_MINITE = 2*60*1000;
    
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CleaningScheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
        File folder = new File("D:\\serverlogs");
        File[] files = folder.listFiles();
       
        
        for (File file: files) {
            if (System.currentTimeMillis() - file.lastModified() > ONE_MINITE) {
                System.out.println("This file will be deleted: " + file.getName());
                //file.delete();
            }
        }
    }
    
}
