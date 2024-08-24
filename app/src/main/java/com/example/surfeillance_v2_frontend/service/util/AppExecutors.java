package com.example.surfeillance_v2_frontend.service.util;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppExecutors {
    private final ExecutorService database;

    public AppExecutors(ExecutorService database) {
        this.database = database;
    }

    public static AppExecutors getInstance(){
        return new AppExecutors(Executors.newFixedThreadPool(4));
    }

    public ExecutorService database(){
        return database;
    }
}
