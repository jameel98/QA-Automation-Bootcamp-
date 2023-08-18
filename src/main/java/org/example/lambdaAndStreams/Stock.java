package org.example.lambdaAndStreams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stock {
    private List<Item> itemsList;

    public Stock() {
        itemsList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            generateItem();
        }
    }

    public void generateItem() {
        String name = Utils.generateRandomName();
        Date expiringDate = Utils.generateRandomDate();
        double weight = Utils.generateRandomWeight();
        Type type = Utils.generateRandomType();
        Item item = new Item(name, expiringDate, weight, type);
        itemsList.add(item);
    }

    public List<Item> getExpiredItems() {
        Date today = new Date(new Date().getTime());
        return itemsList.stream().filter(item -> item.getExpiringDate().before(today)).collect(Collectors.toList());
    }

    public List<Item> getAlphaItems() {
        return itemsList.stream().sorted(Comparator.comparing(Item::getName)).collect(Collectors.toList());
    }

    public Optional<Item> getExpiredItem() {
        Date today = new Date(new Date().getTime());
        return itemsList.stream()
                .filter(item -> item.getExpiringDate().after(today))
                .min(Comparator.comparing(Item::getExpiringDate));
    }

    public Optional<Item> getItem(String name) {
        return itemsList.stream()
                .filter(item -> name.equals(item.getName()))
                .findFirst();
    }

    public List<String> getNamesItemsAboveWeight(double weight) {
        return itemsList.stream()
                .filter(Item -> Item.getWeight() > weight)
                .map(Item::getName).collect(Collectors.toList());
    }

    public HashMap<Type, Integer> getSumTypes() {
        return (HashMap<Type, Integer>) itemsList.stream().collect(Collectors.groupingBy(Item::getItemType, Collectors.summingInt(e -> 1)));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : itemsList) {
            sb.append(item.getName()).append(" ").append(String.format("%.2f", item.getWeight())).append("\n");
        }
        return "itemsList=\n" + sb;
    }

}
