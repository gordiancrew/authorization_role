package com.kazantsev.authorization_role.controllers;

import com.kazantsev.authorization_role.entities.Role;
import com.kazantsev.authorization_role.entities.User;
import com.kazantsev.authorization_role.repos.ImagesRepository;
import com.kazantsev.authorization_role.repos.RoleRepository;
import com.kazantsev.authorization_role.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;

@Controller
public class CreaterController {

    private final String ROLE_USER = "ROLE_USER";
    private final String ROLE_ADMIN = "ROLE_ADMIN";
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ImagesRepository imagesRepository;

    @GetMapping("/creater")
    public String creater(Model model) {
        Role roleUser = new Role();
        roleUser.setId(1);
        roleUser.setName(ROLE_USER);
        Role roleAdmin = new Role();
        roleAdmin.setId(2);
        roleAdmin.setName(ROLE_ADMIN);
        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);
        User admin=new User();
        admin.setUsername("vova");
        admin.setPassword("$2a$10$lIroGsPzn5bsKwFa1TN3a.IlUDRwUOMe9qJ1gYpiAGEN1QeSGIpxG");
        admin.setRoles(Collections.singleton(roleAdmin));
        userRepository.save(admin);
        return "home";
    }

    @GetMapping("/deleter")
    public String deleter(){
        imagesRepository.deleteAll();

        userRepository.deleteAll();
        roleRepository.deleteAll();
        return "home";
    }
}
