package com.solvd.photostudio.model;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GiftCertificate")
public class GiftCertificate {
    private int id;
    private String certificatePrice;
    private int serviceOrderId;

    public GiftCertificate(){}

    public GiftCertificate(String certificatePrice, int serviceOrderId) {
        this.certificatePrice = certificatePrice;
        this.serviceOrderId = serviceOrderId;
    }

    public GiftCertificate(int id, String certificatePrice, int serviceOrderId) {
        this.id = id;
        this.certificatePrice = certificatePrice;
        this.serviceOrderId = serviceOrderId;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }
    @XmlElement
    public String getCertificatePrice() {
        return certificatePrice;
    }
    @XmlElement
    public int getServiceOrderId() {
        return serviceOrderId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCertificatePrice(String certificatePrice) {
        this.certificatePrice = certificatePrice;
    }

    public void setServiceOrderId(int serviceOrderId) {
        this.serviceOrderId = serviceOrderId;
    }

    @Override
    public String toString() {
        return "GiftCertificate " +
                "id = " + id +
                ", certificatePrice = '" + certificatePrice + '\'' +
                ", serviceOrderId = " + serviceOrderId + '\n';
    }
}
