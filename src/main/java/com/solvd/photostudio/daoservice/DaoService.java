package com.solvd.photostudio.daoservice;


public interface DaoService<T> {

    void getAll();
    void insert(T entity);
    void getById(int id);
    void update(T entity, int id);
    void delete(int id);
}
