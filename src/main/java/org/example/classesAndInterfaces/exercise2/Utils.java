package org.example.classesAndInterfaces.exercise2;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public static Gender getOppositeGender(Gender gender) {
        return gender == Gender.MALE ? Gender.FEMALE : Gender.MALE;
    }

    public static int generateRandomNumber(int upperLimit) {
        return ThreadLocalRandom.current().nextInt(upperLimit);
    }

    private static Animal createAnimal(Type type, Gender gender, int id, double weight) {
        switch (type) {
            case DOG:
                return new Dog(gender, id, weight);
            case COW:
                return new Cow(gender, id, weight);
            case HORSE:
                return new Horse(gender, id, weight);
            default:
                throw new IllegalArgumentException("Invalid animal type: " + type);
        }
    }

    public static Animal generateRandomAnimal() {
        Random random = new Random();
        Type type = Type.values()[random.nextInt(Type.values().length)];
        Gender gender = random.nextBoolean() ? Gender.MALE : Gender.FEMALE;
        int id = Utils.generateRandomNumber(100);
        double weight = random.nextDouble() * 100;
        return createAnimal(type, gender, id, weight);
    }

    public static Animal generateAnimalByType(Type type) {
        Random random = new Random();
        Gender gender = random.nextBoolean() ? Gender.MALE : Gender.FEMALE;
        int id = Utils.generateRandomNumber(100);
        double weight = random.nextDouble() * 100;
        return createAnimal(type, gender, id, weight);
    }

    public static Type getAnimalType(String type) {
        switch (type) {
            case "Horse":
                return Type.HORSE;
            case "Dog":
                return Type.DOG;
            case "Cow":
                return Type.COW;
        }
        return null;
    }

}
