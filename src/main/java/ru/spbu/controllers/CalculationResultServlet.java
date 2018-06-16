package ru.spbu.controllers;

import ru.spbu.exception.IllegalExpressionException;
import ru.spbu.models.User;
import ru.spbu.services.CalculationHistoryService;
import ru.spbu.services.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CalculationResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String expression = request.getParameter("expression");

        double result = 0d;
        try {
            result = CalculatorService.calculate(expression);
        } catch (IllegalExpressionException e) {
            request.getSession().setAttribute("error", e);
            response.sendRedirect("illegalExpression.jsp");
            return;
        }

        Object currentUser = request.getSession().getAttribute("currentUser");
        if (currentUser != null) {
            User user = (User) currentUser;
            try {
                new CalculationHistoryService().saveCalculationForUser(expression, result, user.getName());
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        request.setAttribute("result", result);
        request.getRequestDispatcher("calculationResult.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
