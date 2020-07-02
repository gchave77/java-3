package concurrency;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

class Sync extends Thread {
    List nums = new ArrayList<>();

    Sync(String name) {
        super(name);
    }

    @Override
    public synchronized void run() {
        Random rand = new Random();

        for(int i=0; i<100; i++) {
            int randInt = rand.nextInt(100);
            this.nums.add(randInt);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Sync syncThread = new Sync("sync thread");
        syncThread.start();
        syncThread.join();
        System.out.println("Thread 1: " + syncThread.nums);
        System.out.println("Very cool that IntelliJ helps you insert the interrupt exception in the method");

        Sync syncThread2 = new Sync("sync thread2");
        syncThread2.start();
        syncThread2.join();
        System.out.println("Thread 2: " + syncThread2.nums);

        Sync syncThread3 = new Sync("sync thread3");
        syncThread3.start();
        syncThread3.join();
        System.out.println("Thread 3: " + syncThread3.nums);

        Sync syncThread4 = new Sync("sync thread4");
        syncThread4.start();
        syncThread4.join();
        System.out.println("Thread 4: " + syncThread4.nums);

        Sync syncThread5 = new Sync("sync thread5");
        syncThread5.start();
        syncThread5.join();
        System.out.println("Thread 5: " + syncThread5.nums);

        //this prints out an empty list. write some code that will allow the data generated in the syncThread to show up  here.  There is a brute force way and a more sophisticated way.  Either or will work, but strive for sophistication :)

    }
    
}