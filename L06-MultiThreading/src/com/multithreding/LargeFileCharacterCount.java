package com.multithreding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LargeFileCharacterCount {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        File file = new File("/tmp/largefile50mb.txt");
        int chunkSize = 1024 * 1024*5; // 5 MB chunks
        int numThreads = 5;

        // ExecutorService for thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        long start = System.currentTimeMillis();

        // Split file into chunks and submit tasks
        List<Future<Map<Character, Long>>> futures = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String chunk;
            while ((chunk = readChunk(reader, chunkSize)) != null) {
                String finalChunk = chunk;
                Future<Map<Character, Long>> future = executorService.submit(() -> countCharacters(finalChunk));
                futures.add(future);
            }
        }

        // Combine results
        Map<Character, Long> finalResult = new HashMap<>();
        for (Future<Map<Character, Long>> future : futures) {
            Map<Character, Long> partialResult = future.get();
            mergeMaps(finalResult, partialResult);
        }

        // Shutdown the ExecutorService
        executorService.shutdown();

        // Print final results
        finalResult.forEach((character, count) ->
                System.out.println(character + ": " + count));
        long end = System.currentTimeMillis();
        long total = end - start;
        System.out.println("Total Time Taken:"+total+" ms");
    }

    private static String readChunk(BufferedReader reader, int chunkSize) throws IOException {
        char[] buffer = new char[chunkSize];
        int bytesRead = reader.read(buffer, 0, chunkSize);
        return bytesRead > 0 ? new String(buffer, 0, bytesRead) : null;
    }

    private static Map<Character, Long> countCharacters(String chunk) {
        Map<Character, Long> charCount = new HashMap<>();
        for (char c : chunk.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0L) + 1);
        }
        return charCount;
    }

    private static void mergeMaps(Map<Character, Long> finalResult, Map<Character, Long> partialResult) {
        for (Map.Entry<Character, Long> entry : partialResult.entrySet()) {
            finalResult.put(entry.getKey(),
                    finalResult.getOrDefault(entry.getKey(), 0L) + entry.getValue());
        }
    }
}
