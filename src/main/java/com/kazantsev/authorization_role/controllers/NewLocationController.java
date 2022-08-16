package com.kazantsev.authorization_role.controllers;

import com.kazantsev.authorization_role.entities.Stage;
import com.kazantsev.authorization_role.entities.User;
import com.kazantsev.authorization_role.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewLocationController {
   @Autowired
    UserRepository userRepository;


    @GetMapping("/newlocation")
    public String newlocation(Model model){
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userRepository.findByUsername(username);
        Stage stage=user.getStage();
        model.addAttribute("stage",stage);


        return "newlocation";
    }
}
