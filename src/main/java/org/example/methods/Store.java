package org.example.methods;

import java.util.Date;

public class Store {
    public static void assignCouponToUser(User user, Coupon coupon) {
        user.addCoupon(coupon);
    }

    public static boolean useCoupon(User user, Coupon coupon) {
        if (user.getCoupons().contains(coupon) && coupon.getExpireDate().after(new Date())) {
            user.getCoupons().remove(coupon);
            return true;
        }
        return false;
    }
}
