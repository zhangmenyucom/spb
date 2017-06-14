package com.taylor.spb.controller;

import com.taylor.spb.entity.UserEntity;
import com.taylor.spb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user2")
public class UserController2 {
    @Autowired
    private UserService userService;

    @RequestMapping("/find")
    @ResponseBody
    public Object getUser(HttpServletRequest request, UserEntity userEnitty) {

        return userService.queryUser(userEnitty);
    }

    @RequestMapping("/hello/{name}")
    public String hello(Model model, @PathVariable("name") String name) {
        model.addAttribute("name", name);
        model.addAttribute("sex","女");
        return "hello";
    }

}
