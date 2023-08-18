package org.example.classesAndInterfaces.exercise1;

public class Circle implements Shape{

    double mRadious;
    public Circle(double radious) {
        this.mRadious = radious;
    }

    @Override
    public double area() {
        return this.mRadious * this.mRadious * Math.PI;
    }
}
