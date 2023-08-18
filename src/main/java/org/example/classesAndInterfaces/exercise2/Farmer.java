package org.example.classesAndInterfaces.exercise2;


import java.util.ArrayList;
import java.util.List;

public class Farmer {
    private List<Animal> mAnimalsList;
    private Farm farm;

    public Farmer() {
        this.farm = new Farm();
        this.mAnimalsList = new ArrayList<>();
    }

    public void moveAnimal(Animal animal) {
        animal.move();
    }

    public Animal requestAnimal(Type type) {
        Animal animal = farm.requestAnimal(type);
        mAnimalsList.add(animal);
        return animal;
    }

    public void removeAnimal(Animal animal) {
        farm.removeAnimal(animal);
    }

    public void provideAnimalsList() {
        if (mAnimalsList.size() == 0) {
            System.out.println("farmer list is empty add new animals to it");
        } else {
            for (Animal a : mAnimalsList) {
                System.out.println(a.getID() + "-" + a.getClass().getSimpleName());
            }
        }

    }

}
