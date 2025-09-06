package com.shankrish.springbootmvcapp.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @RequestMapping({"", "/", "/index", "/home"})
    public String showTest1() {
        return "index.jsp";
    }

    @RequestMapping("/add1")
    public String addNum1(HttpServletRequest req) {
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));

        int num3 = num1 + num2;
        HttpSession ses = req.getSession();
        ses.setAttribute("num3", num3);

        return "add_elignored.jsp";

    }

    @PostMapping("/add2")
    public String addNum2(HttpServletRequest req) {
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));

        int num3 = num1 + num2;
        HttpSession ses = req.getSession();
        ses.setAttribute("num3", num3);

        return "add_session.jsp";

    }

    @PostMapping("/add3")
    public String addNum3(@RequestParam("num1") int i, @RequestParam("num2") int j, HttpSession ses) {
        int num3 = i + j;
        ses.setAttribute("num3", num3);

        return "add_session.jsp";

    }

    @PostMapping("/add4")
    public ModelAndView addNum4(@RequestParam("num1") int i, @RequestParam("num2") int j) {
        int num3 = i + j;

        ModelAndView mv = new ModelAndView();
        mv.setViewName("add_elignored.jsp");
        mv.addObject("num3", num3);
        return mv;

    }

}
