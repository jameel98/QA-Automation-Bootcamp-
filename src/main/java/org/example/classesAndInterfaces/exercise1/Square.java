package org.example.classesAndInterfaces.exercise1;

public class Square implements Shape{

    private double mLength, mWidth;
    public Square(double aLength, double aWidth){
        this.mLength = aLength;
        this.mWidth = aWidth;
    }
    @Override
    public double area() {
        return this.mWidth * this.mLength;
    }
}
