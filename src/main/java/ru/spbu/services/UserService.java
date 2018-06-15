package ru.spbu.services;

import ru.spbu.dao.RoleDao;
import ru.spbu.dao.UserDao;
import ru.spbu.exception.NoSuchUserException;
import ru.spbu.exception.UserAlreadyExistException;
import ru.spbu.exception.WrongPasswordException;
import ru.spbu.models.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();
    private RoleDao roleDao = new RoleDao();

    public UserService() throws SQLException, ClassNotFoundException {
    }

    public void createUser(String login, String password) throws SQLException, UserAlreadyExistException, ClassNotFoundException {
        boolean exist = checkAlreadyExist(login);

        if (exist) {
            throw new UserAlreadyExistException("user with name " + login + " is already exist");
        }
        userDao.save(login, password);
    }

    private boolean checkAlreadyExist(String login) throws SQLException, ClassNotFoundException {
        return userDao.getByUserName(login) != null;
    }

    public void checkPasswordForUser(String name, String givenPassword) throws SQLException, ClassNotFoundException, WrongPasswordException, NoSuchUserException {
        User user = userDao.getByUserName(name);

        if (user == null) {
            throw new NoSuchUserException("user with name " + name + " does not exist");
        }

        checkPasswordsMatches(givenPassword, user.getPassword());
    }

    private void checkPasswordsMatches(String givenPassword, String password) throws WrongPasswordException {
        if (!givenPassword.equals(password)) {
            throw new WrongPasswordException("wrong password");
        }
    }

    public String getUserRole(String name) throws SQLException, ClassNotFoundException {
        User user = userDao.getByUserName(name);

        return roleDao.getById(user.getId());
    }

    public List<User> getAll() throws SQLException, ClassNotFoundException {
        return userDao.getAll();
    }

    public void deleteUserWithName(String userNameToDelete) throws SQLException, ClassNotFoundException {
        userDao.delete(userNameToDelete);
    }

    public User findUserByName(String userName) throws SQLException, ClassNotFoundException {
        return userDao.getByUserName(userName);
    }
}
