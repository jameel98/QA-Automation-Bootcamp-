package org.example.methods;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        User user = new User("John");

        // Create some Coupons
        Coupon coupon1 = new Coupon(1, new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24), 10.0);
        Coupon coupon2 = new Coupon(2, new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 2), 15.0);
        Coupon coupon3 = new Coupon(3, new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 3), 20.0);

        // Assign Coupons to the User
        Store.assignCouponToUser(user, coupon1);
        Store.assignCouponToUser(user, coupon2);
        Store.assignCouponToUser(user, coupon3);

        // Use Coupons
        System.out.println("User: " + user.getName());
        System.out.println("Coupon with id 1: " + user.getCouponById(1).getId() + " value is: " + user.getCouponById(1).getValue());

        Coupon highestValueCoupon = user.getCouponWithHighestValue();
        System.out.println("Coupon with highest value: " + highestValueCoupon.getId() + " value is: " + user.getCouponById(1).getValue());

        Coupon closestExpiryCoupon = user.getCouponWithClosestExpiryDate();
        System.out.println("Coupon with closest expiry date: " + closestExpiryCoupon.getId() + " value is: " + user.getCouponById(1).getValue());

        Coupon randomCoupon = user.getRandomCoupon();
        System.out.println("Randomly selected coupon: " + randomCoupon.getId() + " value is: " + user.getCouponById(1).getValue());


        System.out.println("Updated Coupons: \n" + user.getCoupons());
    }
}
