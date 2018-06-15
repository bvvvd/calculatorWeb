package ru.spbu.dao;

import ru.spbu.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements Dao<User> {

    @Override
    public void create(User user) {

    }

    @Override
    public void getById(int id) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    public User getByUserName(String login) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username = ?");
        preparedStatement.setString(1, login);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (!resultSet.next()) {
            return null;
        }

        int id = resultSet.getInt("id");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        int role_id = resultSet.getInt("role_id");

        PreparedStatement preparedStatement1 = connection.prepareStatement("select role_name from roles where id = ?");
        preparedStatement1.setInt(1, role_id);

        ResultSet resultSet1 = preparedStatement1.executeQuery();
        resultSet1.next();
        String role_name = resultSet1.getString("role_name");
        return new User(id, username, password, role_name);
    }

    public void save(String login, String password) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionManager.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("insert into users (username, password) values (?, ?)");
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);

        preparedStatement.execute();
    }
}
