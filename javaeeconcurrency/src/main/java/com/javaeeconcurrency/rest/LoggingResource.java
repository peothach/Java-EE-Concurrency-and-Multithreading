package com.javaeeconcurrency.rest;

import com.javaeeconcurrency.runnables.LoggingProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

@RestController
@RequestMapping("/api/v1/logging")
public class LoggingResource {

    private final ExecutorService executorService = Executors.newFixedThreadPool(3);

    @GetMapping
    public String logData() {
        Thread thread = new Thread(new LoggingProcessor());
        thread.setName("Logging-Thread");
        thread.start();

        ExecutorService service = getApplicationPool();
        for (int i=0; i<7; i++){
            service.submit(new LoggingProcessor());
        }

        return "Logging thread its job, check console!";
    }

    public ExecutorService getApplicationPool() {
        return new ThreadPoolExecutor(3,
                10,
                5L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2));
    }
}
