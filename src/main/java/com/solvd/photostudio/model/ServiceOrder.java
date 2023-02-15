package com.solvd.photostudio.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ServiceOrder")
public class ServiceOrder {
    private int id;
    private String orderPrice;
    private int customerId;


    public ServiceOrder() {}

    public ServiceOrder(String orderPrice, int customerId) {
        this.orderPrice = orderPrice;
        this.customerId = customerId;
    }

    public ServiceOrder(int id, String orderPrice, int customerId) {
        this.id = id;
        this.orderPrice = orderPrice;
        this.customerId = customerId;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @XmlElement
    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
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
        return "ServiceOrder " +
                "id = " + id +
                ", orderPrice = '" + orderPrice + '\'' +
                ", customerId = " + customerId + '\n';
    }
}
