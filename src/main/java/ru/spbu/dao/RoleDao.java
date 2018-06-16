package ru.spbu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoleDao implements Dao{
    @Override
    public String getById(int id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select role_name from roles where id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString("role_name");
    }

    @Override
    public void create(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(String o) {

    }

    @Override
    public List getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
