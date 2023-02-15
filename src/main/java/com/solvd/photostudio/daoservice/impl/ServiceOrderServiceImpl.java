package com.solvd.photostudio.daoservice.impl;

import java.util.*;

import com.solvd.photostudio.daoservice.ServiceOrderService;
import com.solvd.photostudio.model.ServiceOrder;

public class ServiceOrderServiceImpl implements ServiceOrderService {

    @Override
    public List<ServiceOrder> getAll() {
        return null;
    }

    @Override
    public void insert(ServiceOrder entity) {}

    @Override
    public Optional<ServiceOrder> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(ServiceOrder entity, int id) {}

    @Override
    public void delete(int id) {}
}
