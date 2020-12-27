package com.modernjava.lambda;

public class IncrementByFiveTraditional implements IncrementByFiveInterface{

    @Override
    public int incrementByFive(int a) {
        return a + 5;
    }
}
