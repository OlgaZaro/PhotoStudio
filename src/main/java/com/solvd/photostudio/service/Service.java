package com.solvd.photostudio.service;

import com.solvd.photostudio.sax.*;


public class Service {

    public static void parsingHandler() {
        CustomerHandler.parsing();
        System.out.println("*  *  *  *  *");
        GiftCertificateHandler.parsing();
        System.out.println("*  *  *  *  *");
        OrderRentalHandler.parsing();
        System.out.println("*  *  *  *  *");
        ServiceOrderHandler.parsing();
        System.out.println("*  *  *  *  *");
        SubscriptionHandler.parsing();
    }
}
