package com.grepp.myboard.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String save = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("geonoo")) {
                    save = cookie.getValue();
                }
            }
        }
        req.setAttribute("save", save);
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

        if (userId.equals("geonoo") && password.equals("1234")) {
            // login success
            HttpSession session = req.getSession();
            session.setAttribute("userId", userId);

            if ("on".equals(remember)) {
                Cookie cookie = new Cookie("geonoo", userId);
                // 쿠키 만료 시간 설정 - 3일
                cookie.setMaxAge(60 * 60 * 24 * 3);
                resp.addCookie(cookie);
            } else {
                // "아이디 기억하기"를 체크하지 않은 경우, 기존 쿠키를 삭제
                Cookie cookie = new Cookie("geonoo", null);
                cookie.setMaxAge(0);    // 쿠키 삭제
                resp.addCookie(cookie);
            }

            req.setAttribute("msg", "로그인 완료되었습니다.");
            req.setAttribute("path", req.getContextPath());
            req.getRequestDispatcher("/WEB-INF/views/alert.jsp").forward(req, resp);
        } else {
            // login fail
            req.setAttribute("msg", "로그인 실패입니다. 아이디나 패스워드를 확인해 주세요.");
            req.setAttribute("path", req.getContextPath() + "/user?action=login");
            req.getRequestDispatcher("/WEB-INF/views/alert.jsp").forward(req, resp);
        }
    }
}
