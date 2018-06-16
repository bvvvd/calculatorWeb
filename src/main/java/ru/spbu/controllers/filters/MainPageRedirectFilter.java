package ru.spbu.controllers.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainPageRedirectFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        Object currentUser = request.getSession().getAttribute("currentUser");

        if (currentUser == null) {
            chain.doFilter(req, resp);
            return;
        }

        response.sendRedirect("userHomePage.jsp");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
