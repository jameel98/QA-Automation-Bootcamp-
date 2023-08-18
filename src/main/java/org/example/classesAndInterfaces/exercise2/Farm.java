package org.example.classesAndInterfaces.exercise2;

import java.util.ArrayList;
import java.util.List;

public class Farm {
    public List<Animal> mAnimalsList;

    public Farm() {
        this.mAnimalsList = new ArrayList<>();
        initializeFarm();

    }
    public List<Animal> getAnimalsList() {
        return this.mAnimalsList;
    }
    public void setAnimalsList(List<Animal> mAnimalsList) {
        this.mAnimalsList = mAnimalsList;
    }
    private void initializeFarm() {
        for (int i = 0; i < 10; i++) {
            Utils.generateRandomAnimal();
            mAnimalsList.add(Utils.generateRandomAnimal());
        }
    }
    public Animal mate(Animal partner) {
        return partner.mate(partner);
    }

    public Animal acquire(Type type) {
        for (Animal animal : this.mAnimalsList) {
            if (animal.getClass().getSimpleName().toUpperCase().equals(type.toString())) {
                Animal mate = findMate(type, animal.getGender());
                if (mate != null) {// check if mate animal exist
                    Animal newAnimal = mate(mate); // if not then make mate
                    if (newAnimal != null) { // if u got the mate then add it to the list
                        this.mAnimalsList.add(newAnimal);
                    }
                }
            }
        }

        // If no existing mate found, create a new animal of the requested type
        Animal animal = Utils.generateAnimalByType(type);
        this.mAnimalsList.add(animal);
        return animal;
    }

    private Animal findMate(Type type, Gender gender) {
        for (Animal animal : mAnimalsList) {
            if (animal.getClass().getSimpleName().toUpperCase().equals(type.toString()) && animal.getGender() != gender) {
                return animal;
            }
        }
        return null;
    }

    public void removeAnimal(Animal animal) {
        mAnimalsList.remove(animal);
    }

    public Animal requestAnimal(Type type) {
        for (Animal a : this.mAnimalsList) {
            if (a.getClass().getSimpleName().toUpperCase().equals(type.toString())) {
                return a;
            }
        }
        return acquire(type);
    }

}
