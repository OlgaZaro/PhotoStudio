package com.solvd.photostudio.jaxb.converter;

import com.solvd.photostudio.jaxb.generic.response.Response;
import com.solvd.photostudio.util.FilePropertiesUtil;
import javax.xml.bind.JAXBException;


public class JaxbUnmarshall {

    public static void unMarshalCustomer() throws JAXBException {
        //Transform XML file to Java Object (Customer)
        Response customerType = JaxBConverter.unmarshall(new FilePropertiesUtil("path").getPath(), Response.class);
        System.out.println(customerType.getObject());
    }

    public static void unMarshalGiftCertificate() throws JAXBException {
        //Transform XML file to Java Object (GiftCertificate)
        Response giftCertificateResponse = JaxBConverter.unmarshall(new FilePropertiesUtil("pathGiftCertificate").getPath(), Response.class);
        System.out.println(giftCertificateResponse.getObject());
    }

    public static void unMarshalOrderRental() throws JAXBException {
        //Transform XML file to Java Object (OrderRental)
        Response orderRentalResponse = JaxBConverter.unmarshall(new FilePropertiesUtil("pathJaxbOrderRental").getPath(), Response.class);
        System.out.println(orderRentalResponse.getObject());
    }

    public static void unMarshalServiceOrder() throws JAXBException {
        //Transform XML file to Java Object (ServiceOrder)
        Response serviceOrderResponse = JaxBConverter.unmarshall(new FilePropertiesUtil("pathJaxbServiceOrder").getPath(), Response.class);
        System.out.println(serviceOrderResponse.getObject());
    }

    public static void unMarshalSubscription() throws JAXBException {
        //Transform XML file to Java Object (Subscription)
        Response subscriptionResponse = JaxBConverter.unmarshall(new FilePropertiesUtil("pathJaxbSubscription").getPath(), Response.class);
        System.out.println(subscriptionResponse.getObject());
    }
}
