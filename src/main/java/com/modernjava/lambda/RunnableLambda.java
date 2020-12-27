package com.modernjava.lambda;

public class RunnableLambda {

    public static void main(String[] args) {
        new Thread( () -> {
            int sum = 0;
            for (int i = 0; i< 10; i ++) {
                sum += i;
            }
            System.out.println("Thread lambda: " + sum);
        }).start();
    }
}
