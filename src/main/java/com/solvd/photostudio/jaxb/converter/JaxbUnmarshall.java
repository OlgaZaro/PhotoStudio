package com.solvd.photostudio.jaxb.converter;

import com.solvd.photostudio.jaxb.generic.response.Response;
import com.solvd.photostudio.util.PropertiesUtil;

import javax.xml.bind.JAXBException;


public class JaxbUnmarshall {

    public static void unMarshalCustomer() throws JAXBException {
        //Transform XML file to Java Object (Customer)
        Response customerType = JaxBConverter.unmarshall(new PropertiesUtil("pathCustomer").getPath(), Response.class);
        System.out.println(customerType.getObject());
    }

    public static void unMarshalGiftCertificate() throws JAXBException {
        //Transform XML file to Java Object (GiftCertificate)
        Response giftCertificateResponse = JaxBConverter.unmarshall(new PropertiesUtil("pathGiftCertificate").getPath(), Response.class);
        System.out.println(giftCertificateResponse.getObject());
    }

    public static void unMarshalOrderRental() throws JAXBException {
        //Transform XML file to Java Object (OrderRental)
        Response orderRentalResponse = JaxBConverter.unmarshall(new PropertiesUtil("pathJaxbOrderRental").getPath(), Response.class);
        System.out.println(orderRentalResponse.getObject());
    }

    public static void unMarshalServiceOrder() throws JAXBException {
        //Transform XML file to Java Object (ServiceOrder)
        Response serviceOrderResponse = JaxBConverter.unmarshall(new PropertiesUtil("pathJaxbServiceOrder").getPath(), Response.class);
        System.out.println(serviceOrderResponse.getObject());
    }

    public static void unMarshalSubscription() throws JAXBException {
        //Transform XML file to Java Object (Subscription)
        Response subscriptionResponse = JaxBConverter.unmarshall(new PropertiesUtil("pathJaxbSubscription").getPath(), Response.class);
        System.out.println(subscriptionResponse.getObject());
    }
}
