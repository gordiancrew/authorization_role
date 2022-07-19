package com.kazantsev.authorization_role.controllers;

import com.kazantsev.authorization_role.entities.Role;
import com.kazantsev.authorization_role.entities.User;
import com.kazantsev.authorization_role.repos.RoleRepository;
import com.kazantsev.authorization_role.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Model model, @RequestParam("username") String username) {
        User user = new User();
        user.setUsername(username);
        user.setPassword("111");
        Role role = roleRepository.getById(1);
        user.setRoles(Collections.singleton(role));
        userRepository.save(user);
        return "infopage";
    }
}
