package com.solvd.photostudio.sax;

import com.solvd.photostudio.util.FilePropertiesUtil;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SubscriptionHandler extends DefaultHandler {
    boolean title = false;
    boolean subscriptionPrice = false;
    boolean customerId = false;


    public static void parsing() {
        try {
            File inputFile = new File(new FilePropertiesUtil("saxSubscription").getPath());
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SubscriptionHandler subscriptionHandler = new SubscriptionHandler();
            saxParser.parse(inputFile, subscriptionHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("subscription")) {
            String id = attributes.getValue("id");
            System.out.println("id : " + id);
        } else if (qName.equalsIgnoreCase("title")) {
            title = true;
        } else if (qName.equalsIgnoreCase("subscriptionPrice")) {
            subscriptionPrice = true;
        } else if (qName.equalsIgnoreCase("customerId")) {
            customerId = true;
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) {
        if (title) {
            System.out.println("title: " + new String(ch, start, length));
            title = false;
        } else if (subscriptionPrice) {
            System.out.println("subscriptionPrice: " + new String(ch, start, length));
            subscriptionPrice = false;
        } else if (customerId) {
            System.out.println("customerId: " + new String(ch, start, length));
            customerId = false;
        }
    }
}

