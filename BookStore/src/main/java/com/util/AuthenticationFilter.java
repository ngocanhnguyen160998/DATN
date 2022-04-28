package com.util;

import com.model.Role;
import com.model.User;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationFilter implements Filter {

    @Autowired
    private RoleService roleService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Role role = null;

        String url = request.getRequestURI();
        User user = (User) SessionUtil.getSession(request, "USER");
        if (user != null) {
            if (url.startsWith(request.getContextPath() + "/admin")) {
                role = roleService.getById(user.getRoleId()).get();
                if ("ADMIN".equals(role.getName())) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
                else if ("USER".equals(role.getName())) {
                    response.sendRedirect((request.getContextPath() + "/"));
                }
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            response.sendRedirect((request.getContextPath() + "/"));
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
