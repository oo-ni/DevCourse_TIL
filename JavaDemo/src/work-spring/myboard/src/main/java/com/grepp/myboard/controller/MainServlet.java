package com.grepp.myboard.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 세션에서 userId 확인
        HttpSession session = req.getSession(false);
        String userId = (String) session.getAttribute("userId");

        if (userId == null) {
            // 로그인하지 않은 경우 로그인 페이지로 리다이렉트
            resp.sendRedirect(req.getContextPath() + "/user?action=login");
        } else {
            // 로그인한 경우 메인 페이지로 포워딩
            req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
        }
    }
}
