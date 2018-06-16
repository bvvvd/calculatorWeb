package ru.spbu.controllers.filters;

import ru.spbu.models.User;
import ru.spbu.services.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class HomePageRedirectFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        Object currentUser = request.getSession().getAttribute("currentUser");
        User user = (User) currentUser;

        try {
            String userRole = new UserService().getUserRole(user.getName());
            if (userRole.equals("user")) {
                chain.doFilter(req, resp);
                return;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("adminUserHomePage.jsp");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
