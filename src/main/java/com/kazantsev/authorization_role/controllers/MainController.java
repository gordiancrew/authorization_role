package com.kazantsev.authorization_role.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String start() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/news")
    public String news() {
        return "news";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/adminuser")
    public String adminuser() {
        return "adminuser";
    }
}
