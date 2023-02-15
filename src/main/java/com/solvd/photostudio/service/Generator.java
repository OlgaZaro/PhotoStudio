package com.solvd.photostudio.service;

import com.solvd.photostudio.enums.*;
import com.solvd.photostudio.jaxb.generic.request.Request;
import com.solvd.photostudio.model.Customer;
import com.solvd.photostudio.model.GiftCertificate;
import com.solvd.photostudio.model.OrderRental;
import com.solvd.photostudio.model.ServiceOrder;
import com.solvd.photostudio.model.Subscription;
import java.util.List;


public class Generator {

    public static Request<Customer> generateCustomer() {
        List<Customer> customerList = CustomerDataBase.fromCustomerDataBase();
        Request<Customer> customerType = new Request<>();
        customerType.setObjects(customerList);

        return customerType;
    }
    public static Request<GiftCertificate> generateGiftCertificate() {
        List<GiftCertificate> giftCertificateList = GiftCertificateDataBase.fromGiftCertificateDataBase();
        Request<GiftCertificate> giftCertificateType = new Request<>();
        giftCertificateType.setObjects(giftCertificateList);

        return giftCertificateType;
    }

    public static Request<OrderRental> generateOrderRental() {
        List<OrderRental> orderRentalList = OrderRentalDataBase.fromOrderRentalDataBase();
        Request<OrderRental> orderRentalType = new Request<>();
        orderRentalType.setObjects(orderRentalList);

        return orderRentalType;
    }

    public static Request<ServiceOrder> generateServiceOrder() {
        List<ServiceOrder> serviceOrderList = ServiceOrderDataBase.fromServiceOrderDataBase();
        Request<ServiceOrder> serviceOrderType = new Request<>();
        serviceOrderType.setObjects(serviceOrderList);

        return serviceOrderType;
    }

    public static Request<Subscription> generateSubscription() {
        List<Subscription> subscriptionList = SubscriptionDataBase.fromSubscriptionDataBase();
        Request<Subscription> subscriptionType = new Request<>();
        subscriptionType.setObjects(subscriptionList);

        return subscriptionType;
    }
}