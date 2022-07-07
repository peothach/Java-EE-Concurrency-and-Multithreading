/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javaconcurency.runnables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhthach
 */
public class AppThread extends Thread {
    
   @Override
   public void run() {
       String pathname = "C:\\Users\\nhthach\\Desktop\\Personal-Git\\Java-EE-Concurrency-and-Multithreading\\Ex_Files_Java_EE_Concurrency\\Exercise Files\\Chapter2\\02_03\\begin\\sample.txt";
       try (BufferedReader reader = new BufferedReader(new FileReader(new File(pathname)))){
           String line = null;
           while ((line=reader.readLine()) != null ){
               System.out.println(Thread.currentThread().getName() + " reading the line: " + line);
           }
       } catch (FileNotFoundException ex) {
           Logger.getLogger(AppThread.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(AppThread.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}
