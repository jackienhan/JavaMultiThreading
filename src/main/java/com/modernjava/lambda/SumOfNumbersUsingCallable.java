package com.modernjava.lambda;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

@SuppressWarnings("unchecked")
public class SumOfNumbersUsingCallable {

    public static int[] arr = IntStream.rangeClosed(0, 5000).toArray();
    public static int total = IntStream.rangeClosed(0, 5000).sum();

    public static void main(String[] args) {

        Callable callable1 = () -> {
            int sum = 0;
            for (int i = 0 ; i < arr.length/2; i++) {
                sum = sum + arr[i];
            }
            return sum;
        };

        Callable callable2 = () -> {
            int sum = 0;
            for (int i = arr.length /2 ; i < arr.length; i++) {
                sum = sum + arr[i];
            }
            return sum;
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Callable<Integer>> taskList = Arrays.asList(callable1, callable2);
        try {
            List<Future<Integer>> results = executorService.invokeAll(taskList);
            int k =0;
            int sum = 0;
            for (Future<Integer> result: results) {
                sum = sum + result.get();
                System.out.println("Sum of " + ++k  + " is : " + result.get());
            }
            System.out.println("Sum from Callable is: " + sum);

            System.out.println("Correct sum from InStream is: " + total);
            executorService.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
