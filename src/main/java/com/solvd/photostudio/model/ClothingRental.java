package com.solvd.photostudio.model;


public class ClothingRental {
    private int id;
    private String title;
    private String clothingPrice;
    private int orderRentalId;

    public ClothingRental(int id, String title, String clothingPrice, int orderRentalId) {
        this.id = id;
        this.title = title;
        this.clothingPrice = clothingPrice;
        this.orderRentalId = orderRentalId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getClothingPrice() {
        return clothingPrice;
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

    public void setClothingPrice(String clothingPrice) {
        this.clothingPrice = clothingPrice;
    }

    public void setOrderRentalId(int orderRentalId) {
        this.orderRentalId = orderRentalId;
    }

    @Override
    public String toString() {
        return "ClothingRental " +
                "id = " + id +
                ", title = '" + title + '\'' +
                ", clothingPrice = '" + clothingPrice + '\'' +
                ", orderRentalId = " + orderRentalId + '\n';
    }
}
