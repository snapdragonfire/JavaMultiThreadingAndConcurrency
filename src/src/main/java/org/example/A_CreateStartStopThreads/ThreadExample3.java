package org.example.A_CreateStartStopThreads;

public class ThreadExample3 {
    public static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("MyRannable running");
            System.out.println("MyRunnable stops");
        }
    }

    public static void main(String[] args) {
        //create an instance of runnable
        Runnable runnable = new MyRunnable();

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
