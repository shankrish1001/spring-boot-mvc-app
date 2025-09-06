package com.shankrish.springbootmvcapp.controller;

import com.shankrish.springbootmvcapp.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @ModelAttribute
    public void modelData(Model m) {
        m.addAttribute("test1", "Test 1111");
        m.addAttribute("test2", "Test 22");
    }

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

    @GetMapping("/add_num_4")
    public String addNum4Ui() {
        return "add_num_4";
    }
    @PostMapping("/add_num_4_act")
    public ModelAndView addNum4Act(@RequestParam("num1") int i, @RequestParam("num2") int j) {
        int num3 = i + j;

        //ModelAndView mv = new ModelAndView();
        //mv.setViewName("add_elignored");
        ModelAndView mv = new ModelAndView("add_elignored");
        mv.addObject("num3", num3);
        return mv;

    }

    @RequestMapping("/add_num_5")
    public String addNum5Ui() {
        return "add_num_5";
    }
    @RequestMapping("/add_num_5_act")
    public String addNum5Act(@RequestParam("num1") int i, @RequestParam("num2") int j, Model m) {
        int num3 = i + j;
        m.addAttribute("num3", num3);
        return "add_elignored";

    }

    @GetMapping("/add_num_6")
    public String addNum6Ui() {
        return "add_num_6";
    }
    @PostMapping("/add_num_6_act")
    public String addNum6Act(@RequestParam("num1") int i, @RequestParam("num2") int j, ModelMap mm) {
        int num3 = i + j;
        mm.addAttribute("num3", num3);
        return "add_elignored";
    }

    @GetMapping("/add_user")
    public String addUserUi() {
        return "add_user";
    }
    @PostMapping("/add_user_act")
    public String addUserAct(@RequestParam("uid") int uid, @RequestParam("uname") String uname, Model m) {
        User user = new User();
        user.setUid(uid);
        user.setUname(uname);
        m.addAttribute(user);
        return "add_user_success";
    }

    @GetMapping("/add_user_model")
    public String addUserModelUi() {
        return "add_user_model";
    }
    @PostMapping("/add_user_obj_act")
    public String addUserModelAct(@ModelAttribute User u, Model m) {
        m.addAttribute("user", u);
        return "add_user_success";
    }

    @GetMapping("/add_user_model_2")
    public String addUserModel2Ui() {
        return "add_user_model_2";
    }
    @PostMapping("/add_user_obj_act_2")
    public String addUserModelAct2(@ModelAttribute("u1") User u) {
        return "add_user_success_2";
    }

    @GetMapping("/add_user_model_3")
    public String addUserModel3Ui() {
        return "add_user_model_3";
    }
    @PostMapping("/add_user_obj_act_3")
    public String addUserModelAct3(User u) {
        return "add_user_success";
    }

}
