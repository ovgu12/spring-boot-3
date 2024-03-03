package com.example.feature;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.*;

@Slf4j
public class Executors {

    public static void main(String[] args) {
        ExecutorService exs = java.util.concurrent.Executors.newFixedThreadPool(1);
        final Runnable r1 = () -> {
            log.info("r1");
        };

        final Runnable r2 = () -> {
            log.info("r2");
        };

        final Callable<Double> c1 = () -> Math.random() * 100;
        final Callable<Double> c2 = () -> Math.random() * 100;
        final var lcs = Arrays.asList(c1, c2);

        final var fut = CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(s -> s.concat(" World"))
                .thenAccept(log::info)
                .thenRun(() -> log.info("Bye"));

        try {
            fut.get();
            exs.execute(r1);
            exs.execute(r2);
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
