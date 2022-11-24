package org.example.B_NameSleepStopDaemon;

public class JoinThread {
    private boolean stopRequested = false;

    public synchronized boolean isStopRequested(){
        return stopRequested;
    }

    public synchronized void requestStop(){
        this.stopRequested = true;
    }

    private static void sleep(long millis) {
        try{
            Thread.sleep(millis);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i=0; i<5; i++){
                sleep(1000);
                System.out.println("Running...");
            }
        };

        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();

        try {
            thread.join(2001);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
