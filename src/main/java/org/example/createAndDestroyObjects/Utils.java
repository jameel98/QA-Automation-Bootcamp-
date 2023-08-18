package org.example.createAndDestroyObjects;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    static ArrayList<String> mNamesArray;

    public static int generateRandomNumber(int upperLimit){
        return ThreadLocalRandom.current().nextInt(upperLimit);
    }

    /**
     * function used in previous version to generate names
     * @return name
     */
    public static String getRandomName(){
        return mNamesArray.get(generateRandomNumber(mNamesArray.size()));
    }
}
