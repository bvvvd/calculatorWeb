package ru.spbu.controllers.filters;

import ru.spbu.models.User;
import ru.spbu.services.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class SecurityFilter implements Filter {
    private UserService userService = new UserService();

    public SecurityFilter() throws SQLException, ClassNotFoundException {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        Object currentUser = request.getSession().getAttribute("currentUser");
        if (currentUser != null) {
            String userName = ((User) currentUser).getName();

            try {
                User userByName = userService.findUserByName(userName);

                if (userByName != null) {
                    chain.doFilter(req, resp);
                    return;
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect("unauthorizedAccess.jsp");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
