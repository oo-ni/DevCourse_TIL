package com.grepp.controller;

import com.grepp.model.dto.MemberDTO;
import com.grepp.model.service.MemberService;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;
//    private final MemberService memberService = MemberService.getInstance();

    @GetMapping("/login")
    public String loginGet(HttpServletRequest req) {

        Cookie[] cookies = req.getCookies();
        String savedId = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("userId".equals(cookie.getName())) {
                    savedId = cookie.getValue();
                    break;
                }
            }
        }
        req.setAttribute("savedId", savedId);

        return "login";
    }

    @PostMapping("/login")
    public String loginPost(MemberDTO member,
                            @RequestParam(value = "remember", required = false) String remember,
                            HttpServletRequest req, HttpServletResponse resp,
                            Model model) throws SQLException {

        String loginId = memberService.login(member.getUserId(), member.getPassword());

        if (loginId != null) {
            HttpSession session = req.getSession();
            session.setAttribute("loginId", loginId);

            if ("on".equals(remember)) {
                Cookie cookie = new Cookie("userId", member.getUserId());
                cookie.setMaxAge(60 * 60 * 24);
                resp.addCookie(cookie);
            }

            model.addAttribute("msg", "로그인 성공 ㅎㅎ");
            model.addAttribute("path", req.getContextPath() + "/main");

            return "alert";

        } else {
            model.addAttribute("msg", "로그인 실패 8ㅅ8");
            model.addAttribute("path", req.getContextPath() + "/member/login");

            return "alert";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req, HttpServletResponse resp, Model model) {
        HttpSession session = req.getSession();
        session.invalidate();

        Cookie cookie = new Cookie("userId", null);
        cookie.setMaxAge(0);
        resp.addCookie(cookie);

        model.addAttribute("msg", "로그아웃 되었습니다-!");
        model.addAttribute("path", req.getContextPath() + "/main");

        return "alert";
    }
}
