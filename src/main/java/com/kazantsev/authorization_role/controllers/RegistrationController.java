package com.kazantsev.authorization_role.controllers;

import com.kazantsev.authorization_role.entities.Role;
import com.kazantsev.authorization_role.entities.Stage;
import com.kazantsev.authorization_role.entities.User;
import com.kazantsev.authorization_role.repos.RoleRepository;
import com.kazantsev.authorization_role.repos.StagesRepository;
import com.kazantsev.authorization_role.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
public class RegistrationController {
    private final String GOOD_REG="регистрация прошла успешно";

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    StagesRepository stagesRepository;

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Model model, @RequestParam("username") String username,@RequestParam("password") String password) {
        User user = new User();
        user.setUsername(username);
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));
        Role role = roleRepository.getById(1);
        user.setRoles(Collections.singleton(role));
        Stage stage=stagesRepository.getById(1);
        user.setStage(stage);
        userRepository.save(user);
        model.addAttribute("info",GOOD_REG);
        return "home";
    }
}
