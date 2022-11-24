package org.example.B_NameSleepStopDaemon;


public class DaemonThreads implements Runnable {
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

    @Override
    public void run() {
        System.out.println("StopAThread running ...");
        while(!stopRequested){
            sleep(1000);
            System.out.println("Current running thread :: . . . . . . . . . . :: "+Thread.currentThread().getName());
        }
        System.out.println("... StopAThread stopped");
    }

    public static void main(String[] args) {
        StopAThread stopAThread = new StopAThread();
        Thread thread = new Thread(stopAThread, "StopAThread Thread");
        //have to set the state to be daemon before starting a particular thread
        thread.setDaemon(true);
        thread.start();
        //can't make a thread daemon after they had already been started as it will throw IllegalThreadStateException
        // -> thread.setDaemon(true);


        try {
            System.out.println("Requesting '"+Thread.currentThread().getName()+"' thread to sleep");
            Thread.sleep(5000);
            System.out.println("'"+Thread.currentThread().getName()+"' thread awakes");
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

//        System.out.println("Requesting StopAThread to stop");
//        stopAThread.requestStop();
//        System.out.println("Stop requested successfully");
    }
}

