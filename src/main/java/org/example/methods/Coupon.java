package org.example.methods;

import java.util.Date;

public class Coupon {

    private int id;
    private Date expireDate;
    private double value;

    public Coupon(int id, Date date, double value){
        this.id = id;
        this.expireDate = date;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String s = "{coupon id: " + this.getId() + " value: " + this.value + " expire date: " + this.expireDate + "}\n";

        return s;
    }
}
