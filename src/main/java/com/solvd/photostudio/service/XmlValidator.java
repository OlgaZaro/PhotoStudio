package com.solvd.photostudio.service;
import java.io.File;


public class XmlValidator {

    public static boolean checkXmlForXSD(String pathXml, String pathXsd) {

        File xml = new File(pathXml);
        File xsd = new File(pathXsd);

        if (!xml.exists()) {
            System.out.println("Not found XML " + pathXml);
        }
        if (!xsd.exists()) {
            System.out.println("Not found XSD " + pathXsd);
        }
        return xml.exists() && xsd.exists();
    }

    public static void validator() {
        boolean b = XmlValidator.checkXmlForXSD("src/main/resources/file/all.xml",
                "src/main/resources/file/all.xsd");
        System.out.println("XML matches XSD : " + b);
    }
}
