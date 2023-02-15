package com.solvd.photostudio.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "subscription")
public class Subscription {
    private int id;
    private String title;
    private String subscriptionPrice;
    private int customerId;


    public Subscription(){}

    public Subscription(String title, String subscriptionPrice, int customerId){
        this.title = title;
        this.subscriptionPrice = subscriptionPrice;
        this.customerId = customerId;
    }

    public Subscription(int id, String title, String subscriptionPrice, int customerId) {
        this.id = id;
        this.title = title;
        this.subscriptionPrice = subscriptionPrice;
        this.customerId = customerId;
    }
    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @XmlElement
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @XmlElement
    public String getSubscriptionPrice() {
        return subscriptionPrice;
    }

    public void setSubscriptionPrice(String subscriptionPrice) {
        this.subscriptionPrice = subscriptionPrice;
    }
    @XmlElement
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Subscription" +
                "id = " + id +
                ", title = '" + title + '\'' +
                ", subscriptionPrice = '" + subscriptionPrice + '\'' +
                ", customerId = " + customerId + '\n';
    }
}
