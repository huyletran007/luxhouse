package com.luxhouse.main.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.luxhouse.main.domain.Users;
import com.luxhouse.main.service.SessionService;

@Component
public class SessionInterceptor implements HandlerInterceptor {
    @Autowired
    SessionService sessionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (sessionService.get("remoteUser", null) != null) {
            Users users = (Users) sessionService.get("remoteUser");
            users.setOrders(null);
            request.setAttribute("UserDataRoot", users);
        }

        return true;
    }

}
