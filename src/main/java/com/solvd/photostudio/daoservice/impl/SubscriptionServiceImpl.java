package com.solvd.photostudio.daoservice.impl;

import java.util.*;

import com.solvd.photostudio.daoservice.SubscriptionService;
import com.solvd.photostudio.model.Subscription;


public class SubscriptionServiceImpl implements SubscriptionService {


    @Override
    public List<Subscription> getAll() {
        return null;
    }

    @Override
    public void insert(Subscription entity) {}

    @Override
    public Optional<Subscription> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Subscription entity, int id) {}

    @Override
    public void delete(int id) {}
}
