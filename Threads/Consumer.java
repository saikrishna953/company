package com.company.Threads;

import java.util.Vector;

public class Consumer implements Runnable {

    private final Vector<Integer> sharedqueue;
    private final int SIZE;

    public Consumer(Vector<Integer> sharedqueue, int size) {
        this.sharedqueue = sharedqueue;
        this.SIZE = size;
    }


    @Override
    public void run() {

        while (true) {
            try {
                System.out.println("Consumed: " + consume());
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            }

        }


    }

    private int consume() throws InterruptedException {
        while (sharedqueue.isEmpty()) {
            synchronized (sharedqueue) {
                System.out.println("Queue is empty " + Thread.currentThread().getName()
                        + " is waiting , size: " + sharedqueue.size());

                sharedqueue.wait();
            }
        }

        synchronized (sharedqueue) {
            sharedqueue.notifyAll();
            return (Integer) sharedqueue.remove(0);
        }
    }
}
