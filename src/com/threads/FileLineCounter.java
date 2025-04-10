package com.threads;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FileLineCounter {

    public void lineCounter() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] files = {"file/file1.txt", "file/file2.txt", "file/file3.txt"};

        for(String filePath : files) {
            executorService.submit(() -> {
                long lineCount = countLines(filePath);
                System.out.println(Thread.currentThread().getName() + " → " + filePath + ": " + lineCount + " lines");
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }

    private long countLines(String filePath) {
        long lineCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            lineCount = br.lines().count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineCount;
    }
}
