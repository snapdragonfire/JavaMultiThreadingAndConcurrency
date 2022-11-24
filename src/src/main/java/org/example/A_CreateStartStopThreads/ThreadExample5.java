package org.example.A_CreateStartStopThreads;

public class ThreadExample5 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String nameOfThread = Thread.currentThread().getName();
            System.out.println("Name of the current thread : "+nameOfThread);
            System.out.println("lambda running");
            System.out.println("lambda finishes");
        };

        Thread thread = new Thread(runnable, "my example 5 thread");
        thread.start();
    }
}
