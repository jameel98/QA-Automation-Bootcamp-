package org.example.lambdaAndStreams;


import java.time.LocalDate;
import java.util.Date;

public class Item {

    private String name;
    private Date expiringDate;
    private double weight;

    private Type type;
    public Item(String name, Date expiringDate, double weight, Type type) {
        this.name = name;
        this.expiringDate = expiringDate;
        this.weight = weight;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpiringDate() {
        return expiringDate;
    }

    public void setExpiringDate(Date expiringDate) {
        this.expiringDate = expiringDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    Type getItemType() {
        return type;
    }

    void setItemType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return getName() + " "  + String.format("%.2f", getWeight());
    }
}
