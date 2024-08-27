package com.grepp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @GetMapping("/")
    public String homePage() {
        return "redirect:/main";
    }

    @GetMapping("/main")
    public ModelAndView mainPage() {
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("msg", "환영합니다!");
        return mav;
    }
}
