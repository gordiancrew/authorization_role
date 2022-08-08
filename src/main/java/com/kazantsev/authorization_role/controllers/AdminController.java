package com.kazantsev.authorization_role.controllers;

import com.kazantsev.authorization_role.entities.Image;
import com.kazantsev.authorization_role.entities.Stage;
import com.kazantsev.authorization_role.repos.StagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    StagesRepository stagesRepository;
    @GetMapping("/admin")
    public String admin(Model model) {
        List<Stage> stagelist=stagesRepository.findAll();
        model.addAttribute("stagelist",stagelist);
        return "admin";
    }
}
