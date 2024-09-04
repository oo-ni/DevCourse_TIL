package com.grepp.boot.controller;

import com.grepp.boot.model.dto.UserDTO;
import com.grepp.boot.model.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String userId, @RequestParam String userPw, HttpSession session, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("alert");

        UserDTO user = userService.getUser(userId);
        if (user != null && user.getUserPw().equals(userPw)) {
            session.setAttribute("loginUser", user);
            mav.addObject("msg", "로그인 성공 !!");
            mav.addObject("path", request.getContextPath() + "/main");
        } else {
            mav.addObject("msg", "로그인 실패 8ㅅ8");
            mav.addObject("path", request.getContextPath() + "/users/login");
        }

        return mav;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session, HttpServletRequest request) {
        session.invalidate();

        ModelAndView mav = new ModelAndView("alert");
        mav.addObject("msg", "로그아웃 되었습니다.");
        mav.addObject("path", request.getContextPath() + "/users/login");

        return mav;
    }
}
