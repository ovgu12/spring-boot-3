package com.example.feature;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Async {

    public static void main(String[] args) {
        ExecutorService exs = Executors.newFixedThreadPool(1);
        final Runnable r1 = () -> {
            log.info("r1");
        };

        final Runnable r2 = () -> {
            log.info("r2");
        };

        final Callable<Double> c1 = () -> {
            return Math.random() * 100;
        };

        final Callable<Double> c2 = () -> {
            return Math.random() * 50;
        };

        final var lcs = Arrays.asList(c1, c2);

        exs.execute(r1);
        exs.execute(r2);

        try {
            var rcs = exs.invokeAll(lcs);
            for (var rc : rcs) {
                log.info(String.valueOf(rc.get()));
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            exs.shutdown();
        }
    }

}
