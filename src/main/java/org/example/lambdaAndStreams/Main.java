package org.example.lambdaAndStreams;

public class Main {
    public static void main(String[] args) {
        Stock s = new Stock();
        System.out.println("All items" + s + "\n");

        System.out.println("List of expired items:" + s.getExpiredItems() + "\n");

        System.out.println("Closest expire date item: " + s.getExpiredItem() + "\n");

        System.out.println("List of items sorted alphabetically: " + s.getAlphaItems() + "\n");

        System.out.println("Item with name olivia " + s.getItem("Olivia") + "\n");

        System.out.println("List of names of items with weight above 20 " + s.getNamesItemsAboveWeight(20.0) + "\n");

        System.out.println("Hashmap contains items types and sum " + s.getSumTypes());

    }
}