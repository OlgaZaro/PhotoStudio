package com.solvd.photostudio.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "OrderRental")
public class OrderRental {
    private int id;
    private String orderPrice;
    private int customerId;


    public OrderRental(){}

    public OrderRental(String orderPrice, int customerId) {
        this.orderPrice = orderPrice;
        this.customerId = customerId;
    }

    public OrderRental(int id, String orderPrice, int customerId) {
        this.id = id;
        this.orderPrice = orderPrice;
        this.customerId = customerId;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }
    @XmlElement
    public String getOrderPrice() {
        return orderPrice;
    }
    @XmlElement
    public int getCustomerId() {
        return customerId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "OrderRental " +
                "id = " + id +
                ", orderPrice = '" + orderPrice + '\'' +
                ", customerId = " + customerId + '\n';
    }
}
