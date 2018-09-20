package com.springbootdemo.byb.person.controller;

import com.springbootdemo.byb.person.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/hello")
    public String hello(Model m) {
        System.out.println("hello-----------------");
        m.addAttribute("name","byb11111");
        return "hello";
    }

    @RequestMapping("/addUser")
    public String addUser(Model m,Person person) {
        m.addAttribute("name","byb11111");
        return "hello";
    }

}
