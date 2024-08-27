package com.grepp.controller.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        String loginId = (String) req.getSession().getAttribute("loginId");
        if (loginId == null) {
            req.setAttribute("msg", "로그인이 필요합니다.");
            req.setAttribute("path", req.getContextPath() + "/member/login");
            req.getRequestDispatcher("/WEB-INF/views/alert.jsp").forward(req, resp);
            return false;
        }
        return true;
    }
}
