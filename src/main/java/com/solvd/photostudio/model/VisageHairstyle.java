package com.solvd.photostudio.model;


public class VisageHairstyle {
    private int id;
    private String title;
    private String servicePrice;
    private int employeeId;

    public VisageHairstyle(int id, String title, String servicePrice, int employeeId) {
        this.id = id;
        this.title = title;
        this.servicePrice = servicePrice;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(String servicePrice) {
        this.servicePrice = servicePrice;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "VisageHairstyle " +
                "id = " + id +
                ", title = '" + title + '\'' +
                ", servicePrice = '" + servicePrice + '\'' +
                ", employeeId = " + employeeId + '\n';
    }
}
