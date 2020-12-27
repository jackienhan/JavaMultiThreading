package com.modernjava.threading;

import java.util.Vector;

@SuppressWarnings("unchecked")
class Producer extends Thread {

    static final int MAXQUEUE = 5;
    private Vector messages = new Vector();

    @Override
    public void run() {
        try {
            while (true) {
                putMessage();
                //sleep(5000);
            }
        } catch (InterruptedException e) {
        }
    }

    private synchronized void putMessage() throws InterruptedException {
        while (messages.size() == MAXQUEUE) {
            wait();
        }
        messages.addElement(new java.util.Date().toString());
        System.out.println("put message");
        notify();

    }


    public synchronized String getMessage() throws InterruptedException {
        notify();
        while (messages.size() == 0) {
            wait();

        }
        String message = (String) messages.firstElement();
        messages.removeElement(message);
        return message;
    }
}

class Consumer extends Thread {

    Producer producer;

    Consumer(Producer p) {
        producer = p;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = producer.getMessage();
                System.out.println("Got message: " + message);
                //sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        Producer producer = new Producer();
        producer.start();
        new Consumer(producer).start();
    }
}
