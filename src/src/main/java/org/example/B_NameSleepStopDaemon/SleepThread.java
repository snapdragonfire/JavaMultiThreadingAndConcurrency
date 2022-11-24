package org.example.B_NameSleepStopDaemon;

public class SleepThread {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String nameOfThread = Thread.currentThread().getName();
            System.out.println("Name of the current thread : "+nameOfThread);
            System.out.println("lambda running");
            long time = 10000;
            System.out.println("Thread going to sleep for " + time/1000 + " sec");
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread going live after " + time/1000 + " sec");
            System.out.println("lambda finishes");
        };

        Thread thread = new Thread(runnable, "My thread name :: NamingOfThreads");
        thread.start();
    }
}
