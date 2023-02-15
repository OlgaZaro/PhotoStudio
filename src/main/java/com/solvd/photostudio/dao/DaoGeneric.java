package com.solvd.photostudio.dao;


import java.util.*;

public interface DaoGeneric<T, V> {
    List<T> getAll();
    void insert(T entity);
    Optional<T> getById(V id);
    void update(T entity, int id);
    void delete(int id);
}
