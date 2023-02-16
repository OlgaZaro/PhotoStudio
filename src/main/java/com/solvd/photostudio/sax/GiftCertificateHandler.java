package com.solvd.photostudio.sax;

import com.solvd.photostudio.util.PropertiesUtil;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class GiftCertificateHandler extends DefaultHandler {
    boolean certificatePrice = false;
    boolean serviceOrderId = false;


    public static void parsing() {
        try {
            File inputFile = new File(new PropertiesUtil("saxGiftCertificate").getPath());
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            GiftCertificateHandler giftCertificateHandler = new GiftCertificateHandler();
            saxParser.parse(inputFile, giftCertificateHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("giftCertificate")) {
            String id = attributes.getValue("id");
            System.out.println("id : " + id);
        } else if (qName.equalsIgnoreCase("certificatePrice")) {
            certificatePrice = true;
        } else if (qName.equalsIgnoreCase("serviceOrderId")) {
            serviceOrderId = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (certificatePrice) {
            System.out.println("certificatePrice: " + new String(ch, start, length));
            certificatePrice = false;
        } else if (serviceOrderId) {
            System.out.println("serviceOrderId: " + new String(ch, start, length));
            serviceOrderId = false;
        }
    }
}
