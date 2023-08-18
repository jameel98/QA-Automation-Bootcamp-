package org.example.classesAndInterfaces.exercise1;

public class Rectangle implements Shape{

    private double mLength;
    public Rectangle(double aLength){
        this.mLength = aLength;

    }

    @Override
    public double area() {
        return this.mLength * this.mLength;
    }
}
