package com.company.Threads;

import java.util.Vector;

public class ProdCon {

    public static void main(String[] args) throws InterruptedException {

        Vector sharedQueue = new Vector();
        int size = 4;
        Thread prodThread = new Thread(new Producer(sharedQueue, size), "Producer");
        Thread consThread = new Thread(new Consumer(sharedQueue, size), "Consumer");
        prodThread.start();
        consThread.start();


    }
}
