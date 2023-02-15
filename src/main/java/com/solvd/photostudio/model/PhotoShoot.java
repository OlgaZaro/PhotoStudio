package com.solvd.photostudio.model;


public class PhotoShoot {
    private int id;
    private String title;
    private String serviceOrderId;
    private int employeeId;

    public PhotoShoot(int id, String title, String serviceOrderId, int employeeId) {
        this.id = id;
        this.title = title;
        this.serviceOrderId = serviceOrderId;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getServiceOrderId() {
        return serviceOrderId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setServiceOrderId(String serviceOrderId) {
        this.serviceOrderId = serviceOrderId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "PhotoShoot " +
                "id = " + id +
                ", title = '" + title + '\'' +
                ", serviceOrderId = '" + serviceOrderId + '\'' +
                ", employeeId = " + employeeId + '\n';
    }
}
