package com.modernjava.lambda;

public class HelloWorldTraditional implements HelloWorldInterface {
    @Override
    public String sayHellWorld() {
        return "Hello Word!";
    }

    @Override
    public Integer total(int a, int b) {
        return a + b;
    }
}
