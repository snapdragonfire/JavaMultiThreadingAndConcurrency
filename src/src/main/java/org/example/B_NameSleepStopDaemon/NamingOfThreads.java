package org.example.B_NameSleepStopDaemon;

public class NamingOfThreads {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String nameOfThread = Thread.currentThread().getName();
            System.out.println("Name of the current thread : "+nameOfThread);
            System.out.println("lambda running");
            System.out.println("lambda finishes");
        };

        Thread thread = new Thread(runnable, "My thread name :: NamingOfThreads");
        thread.start();
    }
}
