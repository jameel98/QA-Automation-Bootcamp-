package org.example.methods;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class User {
    private String name;

    private List<Coupon> couponList;

    public User(String name){
        couponList = new ArrayList<>();
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public List<Coupon> getCoupons() {
        return couponList;
    }
    public void addCoupon(Coupon coupon) {
        couponList.add(coupon);
    }

    public Coupon getCouponById(int id) {
        for (Coupon coupon : couponList) {
            if (coupon.getId() == id) {
                return coupon;
            }
        }
        return null;
    }

    public Coupon getCouponWithHighestValue() {
        Coupon highestValueCoupon = null;
        double maxCouponValue = 0.0;
        for (Coupon coupon : couponList) {
            if (coupon.getValue() > maxCouponValue) {
                maxCouponValue = coupon.getValue();
                highestValueCoupon = coupon;
            }
        }
        return highestValueCoupon;
    }

    public Coupon getCouponWithClosestExpiryDate() {
        Coupon closestExpiryCoupon = null;
        long closestExpiryDiff = Long.MAX_VALUE;
        Date currentDate = new Date();
        for (Coupon coupon : couponList) {
            long diff = coupon.getExpireDate().getTime() - currentDate.getTime();
            if (diff >= 0 && diff < closestExpiryDiff) {
                closestExpiryDiff = diff;
                closestExpiryCoupon = coupon;
            }
        }
        return closestExpiryCoupon;
    }

    public Coupon getRandomCoupon() {
        Random random = new Random();
        if (!couponList.isEmpty()) {
            int randomIndex = random.nextInt(couponList.size());
            return couponList.get(randomIndex);
        }
        return null;
    }

}
