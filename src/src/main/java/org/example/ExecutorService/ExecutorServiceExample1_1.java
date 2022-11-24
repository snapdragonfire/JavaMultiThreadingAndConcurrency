package org.example.ExecutorService;

import java.util.concurrent.*;

public class ExecutorServiceExample1_1 {
    public static void main(String[] args) {
        String task = "Task 1";
        int corePoolSize = 10;
        int maxPoolSize = 20;
        long keepAliveTime = 1000;
        ExecutorService executorService1 = Executors.newFixedThreadPool(corePoolSize);
        executorService1.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " < current thread :: task > " + task);
            }
        });

        executorService1.shutdown();


        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(128));

//        threadPoolExecutor.execute();
    }
}
