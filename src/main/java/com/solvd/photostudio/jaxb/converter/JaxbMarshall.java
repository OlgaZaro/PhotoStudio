package com.solvd.photostudio.jaxb.converter;

import com.solvd.photostudio.jaxb.generic.request.Request;
import com.solvd.photostudio.model.*;
import com.solvd.photostudio.service.Generator;
import com.solvd.photostudio.util.PropertiesUtil;


public class JaxbMarshall {

    public static void marshalCustomer() {
        // Convert Java Object to XML file (Customer)
        Request<Customer> customer = Generator.generateCustomer();
        JaxBConverter.marshall(customer, new PropertiesUtil("pathCustomer").getPath());
    }

    public static void marshalGiftCertificate() {
        //Convert Java Object to XML file (GiftCertificate)
        Request<GiftCertificate> giftCertificate = Generator.generateGiftCertificate();
        JaxBConverter.marshall(giftCertificate, new PropertiesUtil("pathGiftCertificate").getPath());
    }

    public static void marshalServiceOrder() {
        //Convert Java Object to XML file (ServiceOrder)
        Request<ServiceOrder> serviceOrder = Generator.generateServiceOrder();
        JaxBConverter.marshall(serviceOrder, new PropertiesUtil("pathJaxbServiceOrder").getPath());
    }

    public static void marshalOrderRental() {
        //Convert Java Object to XML file (OrderRental)
        Request<OrderRental> orderRental = Generator.generateOrderRental();
        JaxBConverter.marshall(orderRental, new PropertiesUtil("pathJaxbOrderRental").getPath());
    }

    public static void marshalSubscription() {
        //Convert Java Object to XML file (Subscription)
        Request<Subscription> subscription= Generator.generateSubscription();
        JaxBConverter.marshall(subscription, new PropertiesUtil("pathJaxbSubscription").getPath());
    }
}
