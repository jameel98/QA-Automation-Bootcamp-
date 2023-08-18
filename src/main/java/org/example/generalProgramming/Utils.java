package org.example.generalProgramming;

import java.util.ArrayList;
import java.util.Random;

public class Utils {

    ArrayList<String> mNamesArray;
    ArrayList<String> mNamesTemp;

    public Utils(){
       initializeNames();

    }



    /**
     * this method initialize list for names
     * to make them unique
     *
     */
    public void initializeNames(){
        mNamesArray = new ArrayList<>();
        mNamesArray.add("Jack");
        mNamesArray.add("Steve");
        mNamesArray.add("Timon");
        mNamesArray.add("Ahmad");
        mNamesArray.add("Jad");
        mNamesArray.add("Tem");
        mNamesArray.add("Jack");
        mNamesArray.add("Samer");
        mNamesArray.add("Asad");
        mNamesArray.add("Marly");
        mNamesArray.add("Jimmy");
        mNamesArray.add("Naruto");
        mNamesArray.add("Lufi");
        mNamesArray.add("Ace");
        mNamesArray.add("Brad");
        mNamesArray.add("Zoro");
        mNamesTemp = mNamesArray;
    }
    int generateRandomNumber(){
        Random rand = new Random();
        // Setting the upper bound to generate the
        int upperbound = 100;
        int int_random = rand.nextInt(upperbound);
        return int_random;
    }

    String getRandomName(){
        int i = generateRandomNumber()%mNamesTemp.size();
        String mName = mNamesTemp.get(i);
        mNamesTemp.remove(i);
        return mName;
    }
}
