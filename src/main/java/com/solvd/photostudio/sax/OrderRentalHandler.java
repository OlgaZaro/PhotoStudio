package com.solvd.photostudio.sax;

import com.solvd.photostudio.util.PropertiesUtil;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;


public class OrderRentalHandler extends DefaultHandler {
    boolean orderPrice = false;
    boolean customerId = false;


    public static void parsing() {
        try {
            File inputFile = new File(new PropertiesUtil("saxOrderRental").getPath());
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            OrderRentalHandler orderRentalHandler = new OrderRentalHandler();
            saxParser.parse(inputFile, orderRentalHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("orderRental")) {
            String id = attributes.getValue("id");
            System.out.println("id : " + id);
        } else if (qName.equalsIgnoreCase("orderPrice")) {
            orderPrice = true;
        } else if (qName.equalsIgnoreCase("customerId")) {
            customerId = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (orderPrice) {
            System.out.println("OrderPrice: " + new String(ch, start, length));
            orderPrice = false;
        } else if (customerId) {
            System.out.println("CustomerId: " + new String(ch, start, length));
            customerId = false;
        }
    }
}
