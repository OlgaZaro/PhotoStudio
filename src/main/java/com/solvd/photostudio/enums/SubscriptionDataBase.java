package com.solvd.photostudio.enums;

import com.solvd.photostudio.model.Customer;
import com.solvd.photostudio.model.Subscription;

import java.util.ArrayList;
import java.util.List;

public enum SubscriptionDataBase {

    VIP(1, "vip", "5550", 3),
    UNIVERSAL(2, "universal", "4450", 4),
    PREMIUNM(3, "premium", "3350", 2),
    PLATINUM(4, "platinum", "2250", 1),
    STANDART(5, "standart", "1150", 5);

    private final int id;
    private final String title;
    private final String subscriptionPrice;
    private final int customerId;


    SubscriptionDataBase(int id, String title, String subscriptionPrice, int customerId){
        this.id = id;
        this.title = title;
        this.subscriptionPrice = subscriptionPrice;
        this.customerId = customerId;
    }

    public static List<Subscription> fromSubscriptionDataBase() {
        List<Subscription> subscriptionList = new ArrayList<>();
        for (SubscriptionDataBase subscription : values()) {
            subscriptionList.add(new Subscription(subscription.id, subscription.title, subscription.subscriptionPrice, subscription.customerId));
        }
        return subscriptionList;
    }

}
