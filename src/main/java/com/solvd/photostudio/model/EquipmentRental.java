package com.solvd.photostudio.model;


public class EquipmentRental {
    private int id;
    private String title;
    private String equipmentPrice;
    private int orderRentalId;

    public EquipmentRental(int id, String title, String equipmentPrice, int orderRentalId) {
        this.id = id;
        this.title = title;
        this.equipmentPrice = equipmentPrice;
        this.orderRentalId = orderRentalId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getEquipmentPrice() {
        return equipmentPrice;
    }

    public int getOrderRentalId() {
        return orderRentalId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEquipmentPrice(String equipmentPrice) {
        this.equipmentPrice = equipmentPrice;
    }

    public void setOrderRentalId(int orderRentalId) {
        this.orderRentalId = orderRentalId;
    }

    @Override
    public String toString() {
        return "EquipmentRental " +
                "id = " + id +
                ", title = '" + title + '\'' +
                ", equipmentPrice = '" + equipmentPrice + '\'' +
                ", orderRentalId = " + orderRentalId + '\n';
    }
}
