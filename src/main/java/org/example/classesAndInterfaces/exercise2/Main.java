package org.example.classesAndInterfaces.exercise2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      start();
    }

    public static void start() {
        Farmer farmer = new Farmer();
        Animal animal;
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the happy farm press\n" +
                "(q) to exit.\n" +
                "(r) to request animal.\n"  +
                "(m) to move animal.\n"  +
                "(rm) to remove animal.\n" +
                "(p) to provide animal.\n" +
                "(t) t print animals list.\n");

        String s = in.nextLine();

        while (!s.equals("q")){
            switch (s){
                case "r":
                    System.out.println("enter animal type to request. Horse || Cow || Dog");
                    String type = in.nextLine();
                    animal = farmer.requestAnimal(Utils.getAnimalType(type));
                    System.out.println("Requested animal is: " + animal.getID() + "-" + animal.getClass().getSimpleName());
                    break;
                case "m":
                    System.out.println("enter animal type to move. Horse || Cow || Dog");
                    String type2 = in.nextLine();
                    animal = farmer.requestAnimal(Utils.getAnimalType(type2));
                    farmer.moveAnimal(animal);
                    break;
                case "rm":
                    System.out.println("enter animal type to remove. Horse || Cow || Dog");
                    String type3 = in.nextLine();
                    animal = farmer.requestAnimal(Utils.getAnimalType(type3));
                    farmer.removeAnimal(animal);
                    System.out.println("Animal with id= " + animal.getID() + " removed successfully!");
                    break;
                case "p":
                    System.out.println("enter animal type to provide. Horse || Cow || Dog");
                    String type4 = in.nextLine();
                    animal =  farmer.requestAnimal(Utils.getAnimalType(type4));
                    System.out.println("Animal with type " + animal.getClass().getSimpleName() + " added successfully");
                    break;
                case "t":
                    farmer.provideAnimalsList();
                    break;
                default:
                    System.out.println("no command found enter another command");

            }
            s = in.nextLine();
        }
        System.out.println("program closed!");
    }
}
