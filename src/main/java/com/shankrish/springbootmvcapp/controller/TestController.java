package com.shankrish.springbootmvcapp.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @RequestMapping({"", "/", "/index", "/home"})
    public String showTest1() {
        return "index";
    }

    @RequestMapping("/add_num_1")
    public String addNum1Ui() {
        return "add_num_1";
    }
    @RequestMapping("/add_num_1_act")
    public String addNum1Act(HttpServletRequest req) {
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));

        int num3 = num1 + num2;
        HttpSession ses = req.getSession();
        ses.setAttribute("num3", num3);

        return "add_elignored";

    }

    @GetMapping("/add_num_2")
    public String addNum2Ui() {
        return "add_num_2";
    }
    @PostMapping("/add_num_2_act")
    public String addNum2Act(HttpServletRequest req) {
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));

        int num3 = num1 + num2;
        HttpSession ses = req.getSession();
        ses.setAttribute("num3", num3);

        return "add_session";

    }

    @GetMapping("/add_num_3")
    public String addNum3Ui() {
        return "add_num_3";
    }
    @PostMapping("/add_num_3_act")
    public String addNum3Act(@RequestParam("num1") int i, @RequestParam("num2") int j, HttpSession ses) {
        int num3 = i + j;
        ses.setAttribute("num3", num3);

        return "add_session";

    }

    @RequestMapping("/add_num_4")
    public String addNum4Ui() {
        return "add_num_4";
    }
    @PostMapping("/add_num_4_act")
    public ModelAndView addNum4Act(@RequestParam("num1") int i, @RequestParam("num2") int j) {
        int num3 = i + j;

        ModelAndView mv = new ModelAndView();
        mv.setViewName("add_elignored");
        mv.addObject("num3", num3);
        return mv;

    }

}
