package org.example.reflection;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("pop");
        Driver driver = new Driver("pop", "03434534", 23);
        Utils.createInstance(car);
        Utils.createInstance(driver);

        System.out.println(car);
        System.out.println(driver);
    }
}