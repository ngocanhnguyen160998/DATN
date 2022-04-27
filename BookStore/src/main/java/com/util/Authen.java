package com.util;

import com.model.Role;
import com.model.User;
import com.model.request.AuthRequest;
import com.service.RoleService;
import com.service.UserService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

@Component
public class Authen {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    public String auth(AuthRequest authRequest, HttpServletRequest request) {
        User user = userService.getByUserNameAndPassword(authRequest.getUserName(), authRequest.getPassword()).orElse(null);
        SessionUtil.setSession(request, "USER", user);
        if (user == null) {
            SessionUtil.removeSession(request, "USER");
            return "";
        }
        String url = null;
        Role role = roleService.getById(user.getRoleId()).get();
        if ("ADMIN".equals(role.getName())) {
            url = "/admin/home";
        } else if ("USER".equals(role.getName())) {
            url = "/";
        }
        return url;
    }
}
