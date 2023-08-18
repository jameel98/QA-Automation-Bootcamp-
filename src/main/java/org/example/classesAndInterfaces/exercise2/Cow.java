package org.example.classesAndInterfaces.exercise2;

public class Cow extends AbstractAnimal
{

    public Cow(Gender gender, int id, double weight) {
        super(gender, id, weight);
    }
    @Override
    public Animal mate(Animal partner) {
        if (partner instanceof Dog) {
            int id = Utils.generateRandomNumber(100);
            double weight = (mWeight + partner.getWeight()) / 2;
            return new Horse(Utils.getOppositeGender(partner.getGender()), id, weight);
        }
        return null;
    }

    @Override
    public void move() {
        System.out.println("The Cow is moving now");

    }
}
