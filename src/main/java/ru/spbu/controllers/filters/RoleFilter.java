package ru.spbu.controllers.filters;

import ru.spbu.models.User;
import ru.spbu.services.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RoleFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        Object currentUser = request.getSession().getAttribute("currentUser");
        try {
            String userRole = new UserService().getUserRole(((User) currentUser).getName());
            if (userRole.equals("admin")) {
                chain.doFilter(req, resp);
                return;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("noPrivilegesAccess.jsp");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
