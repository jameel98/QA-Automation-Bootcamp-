package org.example.classesAndInterfaces.exercise2;

public class Horse extends AbstractAnimal{
    public Horse(Gender aGender, int aID, double aWeight){
        super(aGender, aID, aWeight);
    }

    @Override
    public Animal mate(Animal partner) {
        if (partner instanceof Horse) {
            int id = Utils.generateRandomNumber(100);
            double weight = (mWeight + partner.getWeight()) / 2;
            return new Horse(Utils.getOppositeGender(partner.getGender()), id, weight);
        }
        return null;
    }

    @Override
    public void move() {
        System.out.println("The Horse is moving now");
    }



}
