class WorkerThread extends Thread {
    public void run() {
        System.out.println("Thread dang chay...");
    }
}

class WorkerRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable dang chay...");
    }
}

public class Bai3_MultiThreading {
    public static void main(String[] args) {
        // Chay Thread
        WorkerThread t1 = new WorkerThread();
        t1.start();

        // Chay Runnable
        Thread t2 = new Thread(new WorkerRunnable());
        t2.start();
    }
}
