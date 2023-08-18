package org.example.generics;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {

        // Call with custom retry count and sleep duration
        Integer integerResult = runWithRetry(Service.integerCallable, 5, 10, 1000);
        System.out.println("Final result: " + integerResult  + " expected result: 5");

        // Call with default retry count and sleep duration
        Double doubleResult = runWithRetry(Service.doubleCallable,10.5,10,1000);
        System.out.println("Final result: " + doubleResult + " expected result: 10.5");

        // Call with default retry count and sleep duration
        Boolean booleanResult = runWithRetry(Service.booleanCallable,true,10,1000);
        System.out.println("Final result: " + booleanResult  + " expected result: true");


    }
    public static <T> T runWithRetry(Callable<T> callable, T expectedResult, int retryCount, int sleepMillis) {
        int retry = 0;
        T result = null;

        while (retry <= retryCount) {
            try {
                result = callable.call();
                if (result.equals(expectedResult)) {
                    return result;
                }
            } catch (Exception e) {
                // Handle any exceptions thrown by the callable
                e.printStackTrace();
            }

            retry++;
            if (retry <= retryCount) {
                try {
                    Thread.sleep(sleepMillis);
                } catch (InterruptedException e) {
                    // Handle InterruptedException if needed
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    // Overload with default sleep and retry limit
    public static <T> T runWithRetry(Callable<T> callable, T expectedResult) {
        return runWithRetry(callable, expectedResult, 3, 1000);
    }

}
