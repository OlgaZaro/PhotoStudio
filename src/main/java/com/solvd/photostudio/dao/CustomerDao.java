package com.solvd.photostudio.dao;

import com.solvd.photostudio.model.Customer;

import java.util.Optional;


public interface CustomerDao extends DaoGeneric <Customer, Integer> {
    Optional<Customer> findByLastName(String lastName);
}
