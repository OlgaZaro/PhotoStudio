package com.solvd.photostudio.enums;

import com.solvd.photostudio.model.Customer;

import java.util.ArrayList;
import java.util.List;


public enum CustomerDataBase {

    JON ( 1,"Jon", "Kennel", "380503344555", "jon@gmail.com"),
    MARTIN (2,"Martin", "Tempt", "380507755997", "kelv@gmail.com"),
    JESSY (3, "Jessy", "Alenti", "380502233445", "jes@gmail.com"),
    TIM( 4,"Tim", "Jonson", "380508844333", "tim@gmail.com"),
    ALINA(5, "Alina", "Kivi", "380505553388", "ali@gmail.com");

    private final int id;
    private final String firstName;
    private final String lastName;
    private final String phone;
    private final String email;

    CustomerDataBase(int id, String firstName, String lastName, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public static List<Customer> fromCustomerDataBase() {
        List<Customer> customerList = new ArrayList<>();
        for (CustomerDataBase customer : values()) {
            customerList.add(new Customer(customer.id, customer.firstName, customer.lastName, customer.phone, customer.email));
        }
        return customerList;
    }
}
