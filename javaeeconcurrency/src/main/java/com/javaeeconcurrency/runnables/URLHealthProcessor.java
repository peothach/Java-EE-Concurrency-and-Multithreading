package com.javaeeconcurrency.runnables;

import java.net.HttpURLConnection;
import java.net.URL;

public class URLHealthProcessor implements Runnable {

    private static final String urlName = "https://www.google.com";

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " checking the health of the application");
        String statusOfApp = "Sorry! Something went wrong";

        try {
            URL url = new URL(urlName);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            if (connection.getResponseCode() == 200) {
                statusOfApp = "Yes, it is working";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Status of the app: " + statusOfApp);
    }
}
