package org.example.generics;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class Service {
     static Callable<Integer> integerCallable = new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
            return ThreadLocalRandom.current().nextInt(10);
        }
    };

    static Callable<Double> doubleCallable = new Callable<Double>() {
        @Override
        public Double call() throws Exception {
            return ThreadLocalRandom.current().nextDouble(10.0);
        }
    };
    static Callable<Boolean> booleanCallable = new Callable<Boolean>() {

        @Override
        public Boolean call() throws Exception {
            return ThreadLocalRandom.current().nextBoolean();
        }

    };
}
