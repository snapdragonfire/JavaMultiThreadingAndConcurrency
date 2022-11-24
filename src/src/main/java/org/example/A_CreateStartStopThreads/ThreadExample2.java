package org.example.A_CreateStartStopThreads;

public class ThreadExample2 {
    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Thread starts");
            System.out.println("Thread stops");
        }
    }

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
    }
}
