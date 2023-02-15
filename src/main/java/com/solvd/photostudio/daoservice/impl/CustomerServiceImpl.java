package com.solvd.photostudio.daoservice.impl;

import java.util.*;

import com.solvd.photostudio.daoservice.CustomerService;
import com.solvd.photostudio.model.Customer;


public class CustomerServiceImpl implements CustomerService {

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public void insert(Customer entity) {}

    @Override
    public Optional<Customer> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Customer entity, int id) {}

    @Override
    public void delete(int id) {}
}
