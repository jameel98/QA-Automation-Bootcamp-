package org.example.classesAndInterfaces.exercise2;

public abstract class AbstractAnimal implements Animal {

    protected Gender mGender;
    protected int mID;
    protected double mWeight;

    public AbstractAnimal(Gender gender, int id, double weight) {
        mGender = gender;
        mID = id;
        mWeight = weight;
    }

    public abstract Animal mate(Animal partner);
    public abstract void move();

    @Override
    public Gender getGender() {
        return mGender;
    }

    @Override
    public int getID() {
        return mID;
    }

    @Override
    public double getWeight() {
        return mWeight;
    }
}
