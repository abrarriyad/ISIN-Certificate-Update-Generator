package com.solvians.showcase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class CertificateUpdateGenerator {
    private final int threads;
    private final int quotes;

    public CertificateUpdateGenerator(int threads, int quotes) {
        this.threads = threads;
        this.quotes = quotes;
    }

    public Stream<CertificateUpdate> generateQuotes() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        List<Future<String>> futures = new ArrayList<>();

        List<CertificateUpdate> updateList = new ArrayList<CertificateUpdate>();
        for (int i = 0; i < threads * quotes; i++) {
            CertificateUpdate certificateUpdate = new CertificateUpdate();
            updateList.add(certificateUpdate);
            futures.add(executorService.submit(certificateUpdate));
        }
        executorService.shutdown();

        for(Future<String> future: futures){
            try{
                System.out.println(future.get());
            } catch (ExecutionException | InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        return updateList.stream();
    }
}
