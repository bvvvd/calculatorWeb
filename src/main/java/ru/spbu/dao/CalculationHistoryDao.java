package ru.spbu.dao;

import ru.spbu.models.Calculation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CalculationHistoryDao implements Dao<Calculation> {

    public List<Calculation> getHistoryForUserWithId(int userId) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionManager.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from calculation_history where user_id = ?");
        preparedStatement.setInt(1, userId);

        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<Calculation> history = new ArrayList<>();

        while (resultSet.next()) {
            Calculation calculation = new Calculation(resultSet.getInt("id"), resultSet.getString("expression"), resultSet.getDouble("result"), resultSet.getInt("user_id"), resultSet.getDate("time"));
            history.add(calculation);
        }

        return history;
    }

    public void saveCalculationForUser(String expression, double result, int id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into calculation_history (expression, result, user_id, time) values (?, ?, ?, ?)");
        preparedStatement.setString(1, expression);
        preparedStatement.setDouble(2, result);
        preparedStatement.setInt(3, id);
        preparedStatement.setDate(4, new Date(System.currentTimeMillis()));

        preparedStatement.execute();
    }

    @Override
    public void create(Calculation calculation) {

    }

    @Override
    public String getById(int id) {
        return null;
    }

    @Override
    public void update(Calculation calculation) {

    }

    @Override
    public void delete(String calculation) {

    }

    @Override
    public List<Calculation> getAll() {
        return null;
    }
}
