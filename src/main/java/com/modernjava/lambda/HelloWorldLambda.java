package com.modernjava.lambda;

public class HelloWorldLambda {
    public static void main(String[] args) {
        HelloWorldInterface helloWorldInterface = new HelloWorldInterface() {
            @Override
            public String sayHellWorld() {
                return "Hell World!!!";
            }

            @Override
            public Integer total(int a, int b) {
                return a + b;
            }
        };

        System.out.println(helloWorldInterface.sayHellWorld());


    }
}
