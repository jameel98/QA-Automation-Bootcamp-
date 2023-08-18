package org.example.javaBasics;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    // Question 2
    public static void main(String[] args) {
        HashMap<Integer, User> myHash = new HashMap<>();
        List<User> myList = new ArrayList<>();
        HelpFuncs helpFuncs = new HelpFuncs();
        for (int i = 0; i < 10; i++){
            int id = helpFuncs.generateRandomNumber();
            String name = helpFuncs.generateRandomString();
            boolean act = id%2 == 0;
            User user = new User(name, id, act);

            myHash.put(i, user);

            myList.add(user);
        }

        // get user by id
        myList.get(5);


        int counter = 0;
        for (User u: myList){
            System.out.println(u.Id);
            if (u.isActivated()){
                counter ++;
            }
        }
        System.out.println(counter);

    }



    //question 1

    void divides (int [] arr, int num) {
        for (int x : arr) {
            if (x % num == 0) {
                System.out.println(x);
            }
        }
    }
    void divide(int [] arr, int num){
        for (int i = 0; i< arr.length; i++){
            if(arr[i]%num == 0){
                System.out.println(arr[i]);
            }
        }
    }

    void divide3 (int [] arr, int num){
        int i = 0;
        while(i < arr.length){
            if(arr[i]%num == 0){
                System.out.println(arr[i]);
            }
            i++;
        }
    }




}