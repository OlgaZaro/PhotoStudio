package com.solvd.photostudio.enums;

import com.solvd.photostudio.model.Customer;
import com.solvd.photostudio.model.GiftCertificate;

import java.util.ArrayList;
import java.util.List;


public enum GiftCertificateDataBase {

    CERTIFICATE_1(1, "2000", 2),
    CERTIFICATE_2(2, "3000", 1),
    CERTIFICATE_3(3, "5000", 3);

    private final int id;
    private final String certificatePrice;
    private final int serviceOrderId;

    GiftCertificateDataBase(int id, String certificatePrice, int serviceOrderId) {
        this.id = id;
        this.certificatePrice = certificatePrice;
        this.serviceOrderId = serviceOrderId;
    }


    public static List<GiftCertificate> fromGiftCertificateDataBase() {
        List<GiftCertificate> giftCertificateList = new ArrayList<>();
        for (GiftCertificateDataBase giftCertificate : values()) {
            giftCertificateList.add(new GiftCertificate(giftCertificate.id, giftCertificate.certificatePrice, giftCertificate.serviceOrderId));
        }
        return giftCertificateList;
    }
}