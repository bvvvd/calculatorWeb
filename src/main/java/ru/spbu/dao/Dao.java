package ru.spbu.dao;

import java.util.List;

public interface Dao<T> {
    void create(T t);

    void getById(int id);

    void update(T t);

    void delete(T t);

    List<T> getAll();
}
