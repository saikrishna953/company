package com.company.Threads;

import java.util.Vector;
import java.util.stream.IntStream;

public class Producer implements Runnable {

    private final Vector<Integer> sharedQueue;
    private final int SIZE;

    public Producer(Vector<Integer> sharedqueue, int size) {
        this.sharedQueue = sharedqueue;
        this.SIZE = size;
    }


    @Override
    public void run() {


        IntStream.range(0, 7).forEach(e -> {
            try {
                System.out.println("Produced: " + e);
                produce(e);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });


    }

    private void produce(int e) throws InterruptedException {

        while (sharedQueue.size() == SIZE) {
            synchronized (sharedQueue) {
                System.out.println("Queue is full " + Thread.currentThread().getName()
                        + " is waiting , size: " + sharedQueue.size());

                sharedQueue.wait();
            }
        }

        //producing element and notify consumers
        synchronized (sharedQueue) {
            sharedQueue.add(e);
            sharedQueue.notifyAll();
        }


    }
}
