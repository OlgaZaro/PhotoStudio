package com.solvd.photostudio.sax;

import com.solvd.photostudio.util.FilePropertiesUtil;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;


public class CustomerHandler extends DefaultHandler {
    boolean isFirstName = false;
    boolean isLastName = false;
    boolean phone = false;
    boolean mail = false;


    public static void parsing() {
        try {
            File inputFile = new File(new FilePropertiesUtil("saxCustomer").getPath());
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            CustomerHandler customerHandler = new CustomerHandler();
            saxParser.parse(inputFile, customerHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("customer")) {
            String id = attributes.getValue("id");
            System.out.println("id : " + id);

        } else if (qName.equalsIgnoreCase("firstName")) {
            isFirstName = true;
        } else if (qName.equalsIgnoreCase("lastName")) {
            isLastName = true;
        } else if (qName.equalsIgnoreCase("phone")) {
            phone = true;
        }  else if (qName.equalsIgnoreCase("mail")) {
            mail = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isFirstName) {
            System.out.println("First Name: " + new String(ch, start, length));
            isFirstName = false;
        } else if (isLastName) {
            System.out.println("Last Name: " + new String(ch, start, length));
            isLastName = false;
        } else if (phone) {
            System.out.println("Phone: " + new String(ch, start, length));
            phone = false;
        } else if (mail) {
            System.out.println("Mail: " + new String(ch, start, length));
            mail = false;
        }
    }
}
