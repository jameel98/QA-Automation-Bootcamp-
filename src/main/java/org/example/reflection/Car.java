package org.example.reflection;

public class Car {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
