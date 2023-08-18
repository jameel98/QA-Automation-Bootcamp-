package org.example.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Optional.empty;

public class Utils {
    static List<String> names = Arrays.asList("John", "Michael", "David", "Sarah", "Emma", "James", "Emily", "William", "Olivia", "Sophia", "Zoro");

    public static String generateRandomName() {

        return names.get(ThreadLocalRandom.current().nextInt(names.size()));
    }

    public static Object createInstance(Object object) {
        try {
            Class<?> aClass = object.getClass();
            Constructor[] constructors = aClass.getDeclaredConstructors();

            for (Constructor c : constructors) {
                if (c.getParameterCount() == 1) {
                    if (c.getParameterTypes()[0].equals(String.class)) {
                        Object newObject = constructors[0].newInstance(generateRandomName());
                        System.out.println("new instance created " + newObject.getClass().getName());
                        return newObject;
                    }

                }

            }
            System.out.println("failed to create new instance of " + object.getClass().getName());
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


}
