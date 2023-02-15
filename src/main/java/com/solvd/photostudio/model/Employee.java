package com.solvd.photostudio.model;


public class Employee {
    private int id;
    private String position;
    private String name;

    public Employee(int id, String position, String name) {
        this.id = id;
        this.position = position;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee " +
                "id = " + id +
                ", position = '" + position + '\'' +
                ", name = '" + name + '\'' + '\n';
    }
}
