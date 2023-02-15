package com.solvd.photostudio.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.photostudio.jaxb.generic.request.Request;
import com.solvd.photostudio.model.*;
import com.solvd.photostudio.util.FilePropertiesUtil;
import com.solvd.photostudio.service.Generator;
import java.io.File;
import java.io.IOException;


public class JsonSerialization {

    public static void serializationCustomer() throws IOException {
        Request<Customer> customer = Generator.generateCustomer();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(new FilePropertiesUtil("jsonCustom").getPath()), customer);
    }

    public static void serializationGiftCertificate() throws IOException {
        Request<GiftCertificate> giftCertificate = Generator.generateGiftCertificate();
        ObjectMapper mapper1 = new ObjectMapper();
        mapper1.writeValue(new File(new FilePropertiesUtil("jsonGiftCertificate").getPath()), giftCertificate);
    }

    public static void serializationOrderRental() throws IOException {
        Request<OrderRental> orderRental = Generator.generateOrderRental();
        ObjectMapper mapper2 = new ObjectMapper();
        mapper2.writeValue(new File(new FilePropertiesUtil("jsonOrderRental").getPath()), orderRental);
    }

    public static void serializationServiceOrder() throws IOException {
        Request<ServiceOrder> serviceOrder = Generator.generateServiceOrder();
        ObjectMapper mapper3 = new ObjectMapper();
        mapper3.writeValue(new File(new FilePropertiesUtil("jsonServiceOrder").getPath()), serviceOrder);
    }

    public static void serializationSubscription() throws IOException {
        Request<Subscription> subscription = Generator.generateSubscription();
        ObjectMapper mapper4 = new ObjectMapper();
        mapper4.writeValue(new File(new FilePropertiesUtil("jsonSubscription").getPath()), subscription);
    }
}
