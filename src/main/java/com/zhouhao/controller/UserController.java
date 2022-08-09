package com.zhouhao.controller;

import com.zhouhao.po.User;
import com.zhouhao.service.CustomerService;
import com.zhouhao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(String userCode, String userPassword, Model model, HttpSession httpSession){
        User user = userService.findUser(userCode, userPassword);

        if(user != null){
            httpSession.setAttribute("USER_SESSION", user);
            return "redirect:/customer/list";
        }
        model.addAttribute("msg", "账号或密码错误，请重新输入！");
        return "login";
    }
    @RequestMapping("/toCustomer")
    public String toCustomer(){
        return "customer";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:toLogin";
    }
}