package com.javaeeconcurrency.rest;

import com.javaeeconcurrency.runnables.URLHealthProcessor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.DefaultManagedTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1/urlCheck")
public class URLHealthResource {

    private final ExecutorService executorService = Executors.newFixedThreadPool(3);
    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    @GetMapping
    public String checkHealthOfApp() {
        String message = "" ;
        scheduledExecutorService.schedule(new URLHealthProcessor(), 3, TimeUnit.SECONDS);
        message = "Health check initiated";
        System.out.println(Thread.currentThread().getName() + ": " + message);
        return message;
    }

}
