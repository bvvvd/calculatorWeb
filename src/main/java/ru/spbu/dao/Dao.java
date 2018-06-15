package ru.spbu.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    void create(T t);

    String getById(int id) throws SQLException, ClassNotFoundException;

    void update(T t);

    void delete(String userName) throws SQLException, ClassNotFoundException;

    List<T> getAll() throws SQLException, ClassNotFoundException;
}
