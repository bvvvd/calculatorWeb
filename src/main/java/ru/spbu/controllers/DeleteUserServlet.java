package ru.spbu.controllers;

import ru.spbu.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteUserServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userNameToDelete = request.getParameter("userNameToDelete");

        try {
            UserService userService = new UserService();
            userService.deleteUserWithName(userNameToDelete);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("deleteUser.jsp").forward(request, response);
    }
}
