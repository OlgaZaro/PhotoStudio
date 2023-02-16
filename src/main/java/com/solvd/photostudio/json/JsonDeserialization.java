package com.solvd.photostudio.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.photostudio.jaxb.generic.request.Request;
import com.solvd.photostudio.util.PropertiesUtil;

import java.io.File;
import java.io.IOException;


public class JsonDeserialization {

    public static void deserializationCustomer() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.readValue(new File(new PropertiesUtil("jsonCustom").getPath()), Request.class).getObject());
    }

    public static void deserializationGiftCertificate() throws IOException {
        ObjectMapper mapper1 = new ObjectMapper();
        System.out.println(mapper1.readValue(new File(new PropertiesUtil("jsonGiftCertificate").getPath()), Request.class).getObject());
    }

    public static void deserializationOrderRental() throws IOException {
        ObjectMapper mapper2 = new ObjectMapper();
        System.out.println(mapper2.readValue(new File(new PropertiesUtil("jsonOrderRental").getPath()), Request.class).getObject());
    }

    public static void deserializationServiceOrder() throws IOException {
        ObjectMapper mapper3 = new ObjectMapper();
        System.out.println(mapper3.readValue(new File(new PropertiesUtil("jsonServiceOrder").getPath()), Request.class).getObject());
    }
    public static void deserializationSubscription() throws IOException {
        ObjectMapper mapper4 = new ObjectMapper();
        System.out.println(mapper4.readValue(new File(new PropertiesUtil("jsonSubscription").getPath()), Request.class).getObject());
    }
}
