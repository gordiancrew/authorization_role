package com.kazantsev.authorization_role.controllers;

import com.kazantsev.authorization_role.entities.Stage;
import com.kazantsev.authorization_role.entities.User;
import com.kazantsev.authorization_role.repos.StagesRepository;
import com.kazantsev.authorization_role.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RepresentController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    StagesRepository stagesRepository;

    @GetMapping("/represent")
    public String represent(Model model, @RequestParam String number) {
        int numberQuest = Integer.parseInt(number);
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userRepository.findByUsername(username);
        Stage stage = stagesRepository.getById(numberQuest);
        user.setStage(stage);
        userRepository.save(user);
        return "redirect:/quests";

    }
}
