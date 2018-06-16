package ru.spbu.services;

import ru.spbu.dao.CalculationHistoryDao;
import ru.spbu.dao.UserDao;
import ru.spbu.models.Calculation;
import ru.spbu.models.User;

import java.sql.SQLException;
import java.util.List;

public class CalculationHistoryService {
    private CalculationHistoryDao calculationHistoryDao = new CalculationHistoryDao();
    private UserDao userDao = new UserDao();

    public List<Calculation> getHistoryForUser(User currentUser) throws SQLException, ClassNotFoundException {
        int id = userDao.getByUserName(currentUser.getName()).getId();

        return calculationHistoryDao.getHistoryForUserWithId(id);
    }

    public void saveCalculationForUser(String expression, double result, String name) throws SQLException, ClassNotFoundException {
        User user = userDao.getByUserName(name);
        calculationHistoryDao.saveCalculationForUser(expression, result, user.getId());
    }
}
