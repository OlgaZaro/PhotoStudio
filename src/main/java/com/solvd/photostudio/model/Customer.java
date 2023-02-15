package com.solvd.photostudio.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer")
public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String mail;


    public Customer(){}

    public Customer(String firstName, String lastName, String phone, String mail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.mail = mail;
    }

    public Customer(int id, String firstName, String lastName, String phone, String mail) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.mail = mail;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    @XmlElement
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @XmlElement
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Customer" +
                ", id = " + id +
                ", firstName = " + firstName +
                ", lastName = " + lastName +
                ", phone = " + phone +
                ", mail = " + mail + '\n';
    }
}