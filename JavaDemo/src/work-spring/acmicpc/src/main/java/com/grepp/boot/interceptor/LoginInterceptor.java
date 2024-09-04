package com.grepp.boot.interceptor;

import com.grepp.boot.model.dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        UserDTO loginUser = (UserDTO) request.getSession().getAttribute("loginUser");

        if (loginUser == null) {
            request.setAttribute("msg", "로그인이 필요합니다.");
            request.setAttribute("path", request.getContextPath() + "/users/login");
            request.getRequestDispatcher("/WEB-INF/views/alert.jsp").forward(request, response);
            return false;
        }

        return true;
    }
}
